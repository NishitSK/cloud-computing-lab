<img width="1827" height="1000" alt="Screenshot 2026-08-11 104010" src="https://github.com/user-attachments/assets/8a82c231-64f8-4cd8-872b-b8306fc000a1" />
<img width="1489" height="767" alt="Screenshot 2026-08-11 104418" src="https://github.com/user-attachments/assets/6dd3cdce-710d-4f91-85dd-ad957c25fe05" />
# Salesforce PDF Email Service

A Salesforce Apex-based email service that retrieves a PDF document and sends it as an email attachment using Salesforce's `Messaging.SingleEmailMessage` API.

## Features

- Send emails directly from Salesforce Apex
- Attach PDF documents to outgoing emails
- Gmail-compatible PDF attachment delivery
- Simple and reusable Apex service class
- Uses Salesforce's native email infrastructure

## Tech Stack

- Salesforce Apex
- Salesforce Developer Console
- Messaging.SingleEmailMessage
- HTTP Callouts
- Gmail

## Project Flow

1. User initiates email sending process.
2. Apex service retrieves the PDF document.
3. PDF is converted into a Blob.
4. Apex creates an email attachment.
5. Salesforce sends the email using `Messaging.sendEmail()`.
6. Recipient receives the PDF attachment in Gmail.

## Apex Service

The core implementation uses:

```apex
Messaging.SingleEmailMessage
Messaging.EmailFileAttachment
Messaging.sendEmail()
