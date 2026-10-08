# AWS S3 and CloudFront Video Streaming

A video streaming service where the video file is stored in a private **Amazon S3** bucket and delivered to viewers through **Amazon CloudFront**.

---

## About

The bucket stays private for the whole exercise. CloudFront is the only thing allowed to read from it, through an origin access control (OAC), so viewers can reach the video only through the CloudFront address.

[player.html](player.html) is a small page with an HTML5 video player. It is uploaded to the same bucket as the video, so it loads `video.mp4` from the same CloudFront address.

It covers:

- Storing a video in a private S3 bucket
- Creating a CloudFront distribution in front of the bucket
- Granting CloudFront read access with a bucket policy
- Playing the video through CloudFront over HTTPS

---

## Technologies Used

- Amazon S3
- Amazon CloudFront
- Origin access control (OAC)
- HTML5 video
- AWS Elemental MediaConvert (optional, for HLS output)

---

## Steps

### 1. Create a private bucket

In the S3 console click **Create bucket**, enter a globally unique name and leave **Block all public access** turned on.

### 2. Upload the files

Upload a test video named `video.mp4` together with `player.html`.

### 3. Create a CloudFront distribution

In the CloudFront console click **Create distribution** and use these settings:

| Setting | Value |
|---|---|
| Origin domain | The S3 bucket from step 1 |
| Origin access | Origin access control settings, with a new OAC |
| Viewer protocol policy | Redirect HTTP to HTTPS |
| Allowed HTTP methods | GET, HEAD |
| Cache policy | CachingOptimized |
| Default root object | `player.html` |

### 4. Allow CloudFront to read the bucket

After the distribution is created, CloudFront shows a bucket policy to copy. Paste it into **S3 > Permissions > Bucket policy**. It has this form:

```json
{
  "Version": "2008-10-17",
  "Id": "PolicyForCloudFrontPrivateContent",
  "Statement": [
    {
      "Sid": "AllowCloudFrontServicePrincipal",
      "Effect": "Allow",
      "Principal": {
        "Service": "cloudfront.amazonaws.com"
      },
      "Action": "s3:GetObject",
      "Resource": "arn:aws:s3:::<BUCKET-NAME>/*",
      "Condition": {
        "StringEquals": {
          "AWS:SourceArn": "arn:aws:cloudfront::<ACCOUNT-ID>:distribution/<DISTRIBUTION-ID>"
        }
      }
    }
  ]
}
```

### 5. Wait for deployment

On the distributions page wait until the status changes from **Deploying** to a last modified date.

### 6. Play the video

Open the distribution domain name in a browser:

```
https://<DISTRIBUTION-DOMAIN>.cloudfront.net
```

The player page loads and the video plays. The video file itself is at `/video.mp4` on the same address.

### 7. Confirm the bucket is private

Open the object URL of `video.mp4` from the S3 console. It returns **AccessDenied**, which shows the video is reachable only through CloudFront.

### 8. Optional: adaptive streaming with MediaConvert

Create an AWS Elemental MediaConvert job with `video.mp4` as the input and an **Apple HLS** output group that writes to the same bucket. CloudFront then serves the `.m3u8` playlist and its segments. DRM encryption in MediaConvert also needs a SPEKE key provider from a DRM vendor.

### 9. Clean up

Disable the distribution and delete it, then empty and delete the bucket.

---

## Project Structure

```
.
├── player.html
└── README.md
```

---

## Screenshots

Not added yet. To capture after the run:

- The bucket with `video.mp4` and `player.html`
- The CloudFront distribution in the deployed state
- The video playing on the `cloudfront.net` address
- The AccessDenied response on the direct S3 URL
