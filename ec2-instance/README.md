# AWS EC2 Instance

Launching a Linux virtual server on **Amazon EC2** and connecting to it over **SSH** with a key pair.

---

## About

This exercise creates a virtual machine in the AWS cloud and logs in to it from a local terminal.

It covers:

- Choosing an Amazon Machine Image (AMI) and an instance type
- Creating a key pair for login
- Opening SSH access in the security group
- Connecting to the running instance
- Stopping or terminating the instance afterwards

An instance like this one hosts the website in [ec2-apache-website](../ec2-apache-website/).

---

## Technologies Used

- AWS EC2
- Amazon Linux
- SSH with a `.pem` key pair
- AWS Management Console

---

## Steps

### 1. Open the EC2 console

Sign in to the AWS Management Console, search for **EC2** and click **Launch instance**.

### 2. Configure the instance

| Setting | Value |
|---|---|
| Name | `lab-instance` |
| AMI | Amazon Linux |
| Instance type | The one labelled **Free tier eligible** (`t2.micro` or `t3.micro`, depending on the region) |
| Key pair | Create new, type RSA, format `.pem` |
| Network settings | Allow SSH traffic from **My IP** |
| Storage | Default |

The `.pem` file downloads once. Keep it safe and never commit it to a repository.

### 3. Launch

Click **Launch instance**, open **Instances** and wait until the instance state is **Running**. Note the **Public IPv4 address**.

### 4. Connect with SSH

On Linux or macOS, restrict the key file first:

```bash
chmod 400 lab-key.pem
```

Then connect:

```bash
ssh -i lab-key.pem ec2-user@<EC2-Public-IP>
```

On Windows the same `ssh` command works in PowerShell. The other option is **Connect > EC2 Instance Connect** in the console, which opens a terminal in the browser.

### 5. Verify the instance

```bash
cat /etc/os-release
```

```bash
uname -a
```

### 6. Stop or terminate

In the console choose **Instance state > Stop instance** to pause it, or **Terminate instance** to delete it. A running instance keeps using Free Tier hours.

---

## Project Structure

```
.
└── README.md
```

---

## Screenshots

Not added yet. To capture after the run:

- Instance summary page showing the state as Running
- SSH session connected to the instance
