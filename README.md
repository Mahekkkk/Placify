# Placify 🚀

> A full-stack Campus Placement Management System built using React, Spring Boot, JWT Authentication, and MySQL.

Placify is a role-based placement management platform designed to streamline campus recruitment processes for students, recruiters, and administrators. The system centralizes job postings, applications, applicant tracking, notifications, and placement analytics into a single platform.

## 📌 Overview

Traditional placement processes often rely on spreadsheets, emails, and manual coordination, resulting in fragmented data and inefficient workflows.

Placify addresses these challenges by providing:

* A centralized placement management platform
* Secure role-based access control
* Real-time application tracking
* Recruiter-driven hiring workflows
* Placement analytics and reporting

### User Roles

#### Student

* Build and manage profile
* Upload resume
* Search and filter jobs
* Apply for jobs
* Track application progress
* Save/bookmark jobs

#### Recruiter

* Create and manage job postings
* Review applicants
* Update application status
* Export applicant data

#### Admin

* Manage companies
* Monitor platform activity
* View placement analytics
* Oversee recruitment workflows

---

# ✨ Key Features

### Authentication & Security

* JWT-based Authentication
* Spring Security Integration
* BCrypt Password Encryption
* Role-Based Access Control (RBAC)
* Forgot Password Workflow
* Secure Password Reset Tokens

### Student Features

* Student Profile Management
* Resume Upload Support
* Advanced Job Search & Filtering
* Job Bookmarking
* One-Click Job Application
* Application Status Tracking

### Recruiter Features

* Job Posting Management
* Applicant Tracking Pipeline
* Status Updates
* CSV Export of Applicants

### Admin Features

* Company Management
* Placement Analytics Dashboard
* Placement Rate Calculation
* Top Hiring Companies Insights

### Notifications

* In-App Notification System
* Unread Notification Tracking
* Email Notifications (Optional)
* Password Reset Emails

---

# 🛠 Tech Stack

| Layer          | Technology                   |
| -------------- | ---------------------------- |
| Frontend       | React 19                     |
| Routing        | React Router v7              |
| HTTP Client    | Axios                        |
| UI Alerts      | SweetAlert2                  |
| Backend        | Spring Boot 4                |
| Language       | Java 21                      |
| Security       | Spring Security, JWT, BCrypt |
| ORM            | Hibernate, Spring Data JPA   |
| Database       | MySQL 8+                     |
| Build Tool     | Maven                        |
| Frontend Build | Vite                         |

---

# 🏗 System Architecture

```text
Frontend (React + Vite)
        │
        ▼
REST API (Spring Boot)
        │
        ▼
Service Layer
        │
        ▼
Repository Layer
        │
        ▼
MySQL Database
```

### Backend Layer Structure

```text
Controller
    ↓
Service
    ↓
Service Implementation
    ↓
Repository
    ↓
JPA Entity
    ↓
MySQL
```

---

# 📂 Project Structure

```text
Placify
│
├── backend
│   ├── controller
│   ├── service
│   ├── repository
│   ├── entity
│   ├── dto
│   ├── security
│   ├── config
│   └── exception
│
├── frontend
│   ├── api
│   ├── components
│   ├── pages
│   ├── hooks
│   ├── context
│   └── assets
│
├── database
│
└── Placify.postman_collection.json
```

---

# 📸 Screenshots

Add screenshots after uploading them to GitHub.

```md
## Login Page
![Login](screenshots/login.png)

## Student Dashboard
![Student Dashboard](screenshots/student-dashboard.png)

## Recruiter Dashboard
![Recruiter Dashboard](screenshots/recruiter-dashboard.png)

## Admin Dashboard
![Admin Dashboard](screenshots/admin-dashboard.png)
```

---

# 🗄 Database Design

### Core Entities

| Entity             | Description                        |
| ------------------ | ---------------------------------- |
| User               | Authentication and role management |
| Student            | Student profile details            |
| RecruiterProfile   | Recruiter information              |
| Company            | Company information                |
| Job                | Job postings                       |
| Application        | Job applications                   |
| SavedJob           | Bookmarked jobs                    |
| Notification       | User notifications                 |
| PasswordResetToken | Password recovery                  |

---

# 🔐 Security Features

* JWT Authentication
* Stateless Session Management
* Password Encryption using BCrypt
* Role-Based Endpoint Authorization
* Method-Level Security using @PreAuthorize
* Secure Password Reset Workflow
* Validation using Jakarta Validation

---

# 📊 Application Workflow

```text
Student Registers
       ↓
Login using JWT
       ↓
Browse Jobs
       ↓
Apply for Job
       ↓
Recruiter Reviews Application
       ↓
Status Updated
       ↓
Student Receives Notification
       ↓
Selection / Rejection
```

---

# 🚀 Quick Start

## Prerequisites

* Java 21
* Maven 3.9+
* MySQL 8+
* Node.js 18+
* npm

---

## Clone Repository

```bash
git clone https://github.com/yourusername/Placify.git
cd Placify
```

---

## Configure Database

Update:

```properties
application.properties
```

```properties
spring.datasource.username=root
spring.datasource.password=your_password
```

---
## ⚙️ Application Configuration

Placify uses environment variables with fallback values defined in `application.properties`.

### Database Configuration

Configure MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/placify?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=your_password
```

Or use environment variables:

#### Windows PowerShell

```powershell
$env:PLACIFY_DB_USERNAME="root"
$env:PLACIFY_DB_PASSWORD="your_password"
```

#### Linux/macOS

```bash
export PLACIFY_DB_USERNAME=root
export PLACIFY_DB_PASSWORD=your_password
```

---

### JWT Configuration

JWT is used for authentication and authorization.

```properties
app.jwt.secret=your_secure_jwt_secret
app.jwt.expiration-ms=86400000
```

For production deployments, always replace the default JWT secret with a strong random value.

---

### Resume Upload Configuration

Uploaded resumes are stored locally.

```properties
app.upload.dir=./uploads
```

Maximum upload size:

```properties
spring.servlet.multipart.max-file-size=2MB
spring.servlet.multipart.max-request-size=2MB
```

---

### Email Configuration (Optional)

Placify supports email notifications for:

* Password Reset
* Application Confirmation
* Application Status Updates

Enable email support:

```properties
app.mail.enabled=true

spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your_email@gmail.com
spring.mail.password=your_app_password

app.mail.from=your_email@gmail.com
```

#### Gmail Setup

1. Enable Two-Factor Authentication on your Google account.
2. Generate a Gmail App Password.
3. Use the generated App Password instead of your Gmail password.

Disable email functionality:

```properties
app.mail.enabled=false
```

The application will continue to work normally without email configuration.

---

### Frontend URL Configuration

Used when generating password reset links.

```properties
app.frontend.url=http://localhost:5173
```

For production:

```properties
app.frontend.url=https://your-domain.com
```

---

### Server Configuration

Default backend port:

```properties
server.port=8080
```

Change if required:

```properties
server.port=9090
```

---

### Seed Data

Placify can automatically load demo companies, jobs, and users.

Enable:

```properties
app.seed.enabled=true
```

Disable:

```properties
app.seed.enabled=false
```

---

### Production Recommendations

Before deploying:

* Change the JWT secret.
* Disable seed data.
* Store sensitive values as environment variables.
* Configure secure database credentials.
* Enable HTTPS.
* Secure SMTP credentials.

Recommended production settings:

```properties
app.seed.enabled=false
app.jwt.secret=<secure-random-secret>
```


## Start Backend

```bash
cd backend
mvn spring-boot:run
```

Backend runs at:

```text
http://localhost:8080
```

---

## Start Frontend

```bash
cd frontend
npm install
npm run dev
```

Frontend runs at:

```text
http://localhost:5173
```

---

# 🔄 API Modules

### Authentication

* Register
* Login
* Forgot Password
* Reset Password

### Student

* Manage Profile
* Upload Resume
* Apply for Jobs
* View Applications

### Recruiter

* Create Jobs
* Manage Applicants
* Update Status

### Admin

* Manage Companies
* View Analytics

### Notifications

* Fetch Notifications
* Mark Notifications Read

---

# 📈 Future Enhancements

* AI-Based Job Recommendations
* Resume Parsing
* Interview Scheduling Module
* Email Verification
* Docker Deployment
* AWS Deployment
* CI/CD Pipeline
* Microservices Architecture
* Real-Time Notifications using WebSockets

---

# 🎯 Learning Outcomes

This project helped me gain practical experience in:

* Spring Boot REST API Development
* Spring Security & JWT Authentication
* React Application Development
* MySQL Database Design
* JPA/Hibernate Relationships
* RESTful API Design
* Exception Handling & Validation
* Role-Based Access Control
* Email Integration
* Full-Stack Application Development

---

# 👩‍💻 Author

**Mahek Vatyani**

MCA Graduate | Java Full Stack Developer

### Skills

* Java
* Spring Boot
* React
* MySQL
* REST APIs
* AWS (Learning)

GitHub: https://github.com/Mahekkkk

LinkedIn: www.linkedin.com/in/mahek-vatyani17

---

# ⭐ Support

If you found this project useful, consider giving it a star on GitHub.
