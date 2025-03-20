# Hotel Management System

## Overview
The Hotel Management System is a Java-based desktop application designed to manage hotel operations efficiently. It provides functionalities for booking rooms, managing customers, and generating reports. The system is built using **Java** with **Apache NetBeans IDE** and uses **MySQL** as the database, connected via **JDBC API**. The **XAMPP server** is used to host the database.

## Features
- **Room Booking & Management**: Enables users to book, cancel, and manage room reservations.
- **Customer Management**: Stores and retrieves customer details for easy access.
- **Employee Management**: Keeps track of hotel staff details and roles.
- **Report Generation**: Provides daily, monthly, and annual reports on hotel operations.

## Technologies Used
- **Programming Language**: Java
- **IDE**: Apache NetBeans
- **Database**: MySQL (via JDBC API)
- **Server**: XAMPP (for MySQL database hosting)

## Installation & Setup
### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/HotelManagementSystem.git
cd HotelManagementSystem
```

### 2. Setup MySQL Database
- Start XAMPP and enable MySQL service.
- Open **phpMyAdmin** and create a new database (e.g., `hotel_db`).
- Import the SQL script from the project directory (`hotel_db.sql`).

### 3. Configure JDBC Connection
- Open the project in **Apache NetBeans**.
- Modify the **database configuration** in the Java code:
  ```java
  String url = "jdbc:mysql://localhost:3306/hotel_db";
  String user = "root";
  String password = ""; // Default XAMPP password
  Connection conn = DriverManager.getConnection(url, user, password);
  ```

### 4. Run the Application
- Build and run the project in **NetBeans**.
- Log in using admin credentials (default: `admin/admin`).
- Start managing hotel operations!

## Usage
1. **Login** with admin or staff credentials.
2. **Manage Bookings**: Add, update, or cancel room reservations.
3. **Customer Management**: Register new customers and retrieve past records.
4. **Reports & Analytics**: View operational reports for business insights.

## Troubleshooting
- **Database Connection Error?** Check if MySQL is running in XAMPP.
- **Invalid Credentials?** Verify login details in the database (`users` table).
- **Application Not Running?** Ensure JDBC driver is correctly included in project libraries.



