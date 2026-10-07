# AWS EC2 Apache Web Server

A simple static website hosted on an **Amazon EC2** instance using **Apache HTTP Server (httpd)** running on **Amazon Linux**.

## 🌐 Live Demo

**Website:** http://13.50.241.76

**GitHub Repository:** https://github.com/NishitSK/cloud_scem_misision

---

## 📖 About

This project demonstrates how to deploy a static website on an AWS EC2 instance using Apache HTTP Server.

The website includes:

- College Vision & Mission
- Department Vision & Mission
- Student Information
- Responsive HTML/CSS Design
- Hidden JavaScript Easter Egg Game

---

## 🛠️ Technologies Used

- AWS EC2
- Amazon Linux
- Apache HTTP Server (httpd)
- HTML5
- CSS3
- JavaScript

---

## 🚀 Deployment Steps

### 1. Update the system

```bash
sudo yum update -y
```

### 2. Install Apache

```bash
sudo yum install httpd -y
```

### 3. Start Apache

```bash
sudo systemctl start httpd
```

### 4. Enable Apache on boot

```bash
sudo systemctl enable httpd
```

### 5. Create the HTML file

```bash
nano index.html
```

### 6. Copy the website to Apache's web directory

```bash
sudo cp index.html /var/www/html/index.html
```

### 7. Verify Apache is running

```bash
sudo systemctl status httpd
```

### 8. Access the website

```
http://<EC2-Public-IP>
```

---

## 🔄 Updating the Website

Edit the local HTML file:

```bash
nano index.html
```

Deploy the updated version:

```bash
sudo cp index.html /var/www/html/index.html
```

Refresh the browser to see the changes.

---

## 📂 Project Structure

```
.
├── index.html
└── README.md
```

---

## 👨‍💻 Author

**Nishit S K**

- USN: 4SF23CS130
- Department: Computer Science and Engineering
- Sahyadri College of Engineering and Management

---

## 🎮 Easter Egg

A hidden game is embedded within the website.

**Hint:** Type `GAME`
<img width="1920" height="1080" alt="Screenshot 2026-07-21 125733" src="https://github.com/user-attachments/assets/af74952e-2103-4b7e-8d71-b324b3d05fde" />
<img width="1920" height="1080" alt="Screenshot 2026-07-21 125747" src="https://github.com/user-attachments/assets/31940e55-be67-48bd-b447-180ab52e62e2" />
