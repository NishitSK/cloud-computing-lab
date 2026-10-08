# Azure Threaded Image Processing

A thread-based image processing application that works on images stored in **Azure Blob Storage**. Each image is processed in its own thread.

---

## About

The script in [app.py](app.py) connects to a storage account, finds every image in the `images` container and starts one thread per image.

Each thread:

1. Downloads the image from Blob Storage
2. Converts it to grayscale and resizes it to 200 x 200
3. Uploads the result as a JPEG under the `processed/` prefix in the same container

The storage connection string is read from an environment variable, so it is never written into the code.

---

## Technologies Used

- Microsoft Azure Storage Account (Blob Storage)
- Python 3
- `azure-storage-blob`
- Pillow
- Python `threading` module

---

## Steps

### 1. Create a storage account

In the Azure Portal open **Storage accounts > Create**. Pick a resource group, a unique account name and the nearest region, then **Review + create**.

### 2. Create a container

Open the storage account, go to **Containers**, click **+ Container** and name it `images`. Keep the access level private.

### 3. Upload sample images

Open the `images` container, click **Upload** and add a few JPEG or PNG files.

### 4. Copy the connection string

In the storage account open **Security + networking > Access keys** and copy the **Connection string**. Treat it like a password.

### 5. Install the libraries

```bash
pip install -r requirements.txt
```

### 6. Set the connection string

In PowerShell:

```powershell
$env:AZURE_STORAGE_CONNECTION_STRING = "<connection-string>"
```

In Bash, or in Azure Cloud Shell:

```bash
export AZURE_STORAGE_CONNECTION_STRING="<connection-string>"
```

### 7. Run the application

```bash
python app.py
```

The script prints one line per image with the name of the thread that handled it, then the number of images processed.

### 8. Check the result

Refresh the `images` container in the portal. The processed copies are inside the `processed` folder.

### 9. Clean up

Delete the resource group when finished so the storage account stops using credit.

---

## Project Structure

```
.
├── app.py
├── requirements.txt
└── README.md
```

---

## Screenshots

Not added yet. To capture after the run:

- The `images` container with the uploaded files
- Terminal output of `python app.py`
- The `processed` folder with the resized images
