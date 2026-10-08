import io
import os
import threading

from azure.storage.blob import BlobServiceClient, ContentSettings
from PIL import Image

CONTAINER_NAME = "images"
OUTPUT_PREFIX = "processed/"
SIZE = (200, 200)


def make_thumbnail(data):
    """Convert the image to grayscale, resize it to SIZE and return JPEG bytes."""
    image = Image.open(io.BytesIO(data))
    image = image.convert("L").resize(SIZE)

    output = io.BytesIO()
    image.save(output, format="JPEG")
    return output.getvalue()


def process_blob(container, blob_name):
    data = container.download_blob(blob_name).readall()
    result = make_thumbnail(data)

    new_name = OUTPUT_PREFIX + os.path.splitext(blob_name)[0] + ".jpg"
    container.upload_blob(
        new_name,
        result,
        overwrite=True,
        content_settings=ContentSettings(content_type="image/jpeg"),
    )
    print(f"{threading.current_thread().name}: {blob_name} -> {new_name}")


def main():
    # Read the key from the environment so it never ends up in the repo
    connection_string = os.environ["AZURE_STORAGE_CONNECTION_STRING"]
    service = BlobServiceClient.from_connection_string(connection_string)
    container = service.get_container_client(CONTAINER_NAME)

    # Skip earlier results so a second run does not process its own output
    names = [
        blob.name
        for blob in container.list_blobs()
        if not blob.name.startswith(OUTPUT_PREFIX)
    ]

    # One thread per image
    threads = [
        threading.Thread(target=process_blob, args=(container, name))
        for name in names
    ]
    for thread in threads:
        thread.start()
    for thread in threads:
        thread.join()

    print(f"Processed {len(threads)} image(s)")


if __name__ == "__main__":
    main()
