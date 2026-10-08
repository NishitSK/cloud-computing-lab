# Google App Engine Web App

A small Python web application launched on **Google App Engine**, first on the local machine and then on Google Cloud.

---

## About

The application in [main.py](main.py) is a plain Python WSGI app with no external packages. It serves one page that shows the server time, generated on each request.

The original App Engine Launcher was a desktop tool bundled with the old Python 2.7 SDK. The **gcloud CLI** does that job now, so this exercise uses it to launch the application.

It covers:

- Running the application locally
- Creating an App Engine application in a Google Cloud project
- Deploying with `gcloud app deploy`
- Opening the live URL

---

## Technologies Used

- Google App Engine (standard environment)
- Google Cloud CLI (`gcloud`)
- Python 3
- WSGI

---

## Steps

### 1. Run the application locally

```bash
python main.py
```

Open http://localhost:8080 in a browser. Stop the server with `Ctrl+C`.

### 2. Create a Google Cloud project

In the Google Cloud Console create a new project and link a billing account to it. App Engine needs billing enabled to deploy. An app this small normally stays within the free tier.

### 3. Install and set up the gcloud CLI

Install it from https://cloud.google.com/sdk/docs/install and then run:

```bash
gcloud init
```

Sign in and select the project.

### 4. Create the App Engine application

```bash
gcloud app create --region=asia-south1
```

### 5. Deploy

Run this from the folder that contains `app.yaml`:

```bash
gcloud app deploy
```

### 6. Open the website

```bash
gcloud app browse
```

The address has the form:

```
https://<PROJECT-ID>.<REGION-ID>.r.appspot.com
```

### 7. Clean up

In the console open **App Engine > Settings** and click **Disable application**, or delete the project.

---

## Project Structure

```
.
├── app.yaml
├── main.py
└── README.md
```

---

## Screenshots

Not added yet. To capture after the run:

- The page running on `localhost:8080`
- `gcloud app deploy` finishing in the terminal
- The page running on the `appspot.com` address
