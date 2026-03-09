# Student Data Application

A simple web-based application built with Java to manage and display student performance data.

## Description
This application is designed using the MVC (Model-View-Controller) pattern with a dedicated Service Layer to handle business logic. It allows users to authenticate and view student marks, including automated pass-rate calculations per department.

## Key Features
- **Authentication**: Simple login access control.
- **Data Display**: Structured student information table.
- **Logic Handling**: Server-side processing for department statistics.

## Available Routes
The application uses clean URLs:
- `/login` : The entry point for user authentication.
- `/welcome` : The main dashboard displaying student data (requires login).

## Installation & Setup
1. **Clone Project**: Download or clone this repository.
2. **Build**: Run `mvn clean package` to generate the WAR file.
3. **Deployment**:
    - Deploy to **Apache Tomcat 11**.
    - Ensure the **Application Context** is set to `/`.
4. **Access**: Open `http://localhost:8081/login` in your browser.

## Credentials
- **Username**: `admin`
- **Password**: `admin123`