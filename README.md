# Cloud Computing Lab

Eleven cloud computing lab experiments, each in its own folder with its own README.

| No. | Experiment | Folder | Platform |
|:---:|---|---|---|
| 1 | Install VirtualBox with different flavors of Linux or Windows OS | [virtualbox-setup](virtualbox-setup/) | VirtualBox |
| 2 | Install a C compiler in the virtual machine and execute a simple program | [c-program-in-vm](c-program-in-vm/) | VirtualBox, Ubuntu |
| 3 | Create an EC2 instance in AWS | [ec2-instance](ec2-instance/) | AWS EC2 |
| 4 | Develop a simple application using Apex on Salesforce | [salesforce-apex-app](salesforce-apex-app/) | Salesforce |
| 5 | Implement a mailing service using Apex on Salesforce | [salesforce-pdf-mailer](salesforce-pdf-mailer/) | Salesforce |
| 6 | Simulate a cloud scenario using CloudSim and run a scheduling algorithm | [cloudsim-scheduling](cloudsim-scheduling/) | CloudSim |
| 7 | Thread based image processing application in Microsoft Azure | [azure-image-processing](azure-image-processing/) | Microsoft Azure |
| 8 | Deploy a web application on an EC2 instance on AWS | [ec2-apache-website](ec2-apache-website/) | AWS EC2 |
| 9 | Launch a web application using Google App Engine | [app-engine-web-app](app-engine-web-app/) | Google Cloud |
| 10 | Deploy a static web application using S3 and secure it with signed URLs | [s3-static-website](s3-static-website/) | AWS S3 |
| 11 | Create a video streaming service using S3 and CloudFront | [s3-cloudfront-video-streaming](s3-cloudfront-video-streaming/) | AWS S3, CloudFront |

Open a folder to see its README for the details and steps. Experiments 5 and 8 include screenshots of the run. The screenshots for the others are still to be added.

## Layout

```
.
├── README.md
├── virtualbox-setup/
│   └── README.md
├── c-program-in-vm/
│   ├── README.md
│   └── sum.c
├── ec2-instance/
│   └── README.md
├── salesforce-apex-app/
│   ├── README.md
│   └── HelloApex.cls
├── salesforce-pdf-mailer/
│   ├── README.md
│   └── apex.cls
├── cloudsim-scheduling/
│   ├── README.md
│   ├── SjfBroker.java
│   └── SjfSchedulingExample.java
├── azure-image-processing/
│   ├── README.md
│   ├── app.py
│   └── requirements.txt
├── ec2-apache-website/
│   ├── README.md
│   └── index.html
├── app-engine-web-app/
│   ├── README.md
│   ├── app.yaml
│   └── main.py
├── s3-static-website/
│   ├── README.md
│   └── index.html
└── s3-cloudfront-video-streaming/
    ├── README.md
    └── player.html
```

## History

Experiments 5 and 8 were first kept in two separate repositories. Their commits are kept here as they were.

- `cloud_scem_misision` is now `ec2-apache-website/`
- `CLOUDSIM_APEX` is now `salesforce-pdf-mailer/`

## Author

**Nishit S K**

- USN: 4SF23CS130
- Department: Computer Science and Engineering
- Sahyadri College of Engineering and Management
