# AWS S3 Static Website with Signed URLs

A static website hosted on **Amazon S3**, then locked down so the page opens only through a time-limited **presigned URL**.

---

## About

The exercise has two parts.

**Part A** hosts [index.html](index.html) from an S3 bucket using static website hosting, with a bucket policy that allows public reads.

**Part B** removes the public access and shares the page through a presigned URL instead. The URL carries a signature made with the owner's AWS credentials and stops working when it expires.

The page keeps its CSS inline. A presigned URL signs exactly one object, so a separate stylesheet would need its own URL.

---

## Technologies Used

- Amazon S3
- S3 static website hosting
- S3 presigned URLs
- AWS CLI
- HTML5 and CSS3

---

## Steps

### Part A: Host the website

#### 1. Create a bucket

In the S3 console click **Create bucket**, enter a globally unique name and untick **Block all public access**.

#### 2. Upload the page

Open the bucket, click **Upload** and add `index.html`.

#### 3. Enable static website hosting

Open **Properties > Static website hosting > Edit**, choose **Enable** and set the index document to `index.html`.

#### 4. Allow public reads

Open **Permissions > Bucket policy > Edit** and add this policy with the bucket name filled in:

```json
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "PublicReadGetObject",
      "Effect": "Allow",
      "Principal": "*",
      "Action": "s3:GetObject",
      "Resource": "arn:aws:s3:::<BUCKET-NAME>/*"
    }
  ]
}
```

#### 5. Open the website

The address is listed under **Properties > Static website hosting**:

```
http://<BUCKET-NAME>.s3-website.<REGION>.amazonaws.com
```

### Part B: Secure it with a signed URL

#### 6. Remove public access

Delete the bucket policy, then turn **Block all public access** back on under **Permissions**.

#### 7. Confirm the page is private

Reload the website address from step 5. It now returns **403 Forbidden**.

#### 8. Generate a presigned URL

```bash
aws s3 presign s3://<BUCKET-NAME>/index.html --expires-in 300 --region <REGION>
```

AWS CloudShell in the console has the AWS CLI already signed in. The same can also be done without the CLI: select `index.html`, then **Object actions > Share with a presigned URL**.

#### 9. Open the presigned URL

Paste the URL into a browser. The page loads.

#### 10. Wait for it to expire

After 300 seconds the same URL returns **AccessDenied** with the message that the request has expired.

#### 11. Clean up

Empty the bucket and delete it.

---

## Project Structure

```
.
├── index.html
└── README.md
```

---

## Screenshots

Not added yet. To capture after the run:

- The page open on the S3 website address (Part A)
- The 403 response after public access is removed
- The page open through the presigned URL
- The AccessDenied response after the URL expires
