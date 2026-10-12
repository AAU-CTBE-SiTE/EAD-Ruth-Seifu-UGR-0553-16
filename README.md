# Lab 1: Java Maven Starter Project

A starter Java project managed with Apache Maven demonstrating how to establish a JDBC (Java Database Connectivity) connection to a MySQL database.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Database Setup](#database-setup)
- [Configuration](#configuration)
- [Building and Running](#building-and-running)
- [Code Overview](#code-overview)
- [Troubleshooting](#troubleshooting)

---

## 📖 Overview

This project serves as a foundational template for Java Enterprise Application Development (EAD). It demonstrates:
- Managing project dependencies using Maven (`pom.xml`).
- Utilizing the official MySQL Connector/J driver.
- Connecting to a local MySQL instance using standard JDBC APIs (`DriverManager` and `Connection`).

---

## ⚙️ Prerequisites

Before running this project, ensure you have the following installed:

- **Java Development Kit (JDK) 21** or higher:
  ```bash
  java -version
  ```
- **Apache Maven 3.8+**:
  ```bash
  mvn -version
  ```
- **MySQL Server** (running locally on port `3306`):
  ```bash
  mysql --version
  ```

---

## 📁 Project Structure

```text
enterprise/
├── pom.xml
├── README.md
└── src/
    └── main/
        └── java/
            └── org/
                └── example/
                    ├── JDBCDemo.java   # Demo class establishing JDBC connection
                    └── Main.java       # Main entry point with JDBC connection template
```

---

## 🗄️ Database Setup

1. Start your MySQL server if it is not already active:
   ```bash
   sudo systemctl status mysql    # or: sudo service mysql status
   ```

2. Log in to MySQL as root or an administrative user:
   ```bash
   mysql -u root -p
   ```

3. Create the database used by the application (`StudentsDB`):
   ```sql
   CREATE DATABASE StudentsDB;
   ```

4. *(Optional)* Create a dedicated user and grant permissions:
   ```sql
   CREATE USER 'ruth'@'localhost' IDENTIFIED BY 'YOUR_PASSWORD';
   GRANT ALL PRIVILEGES ON StudentsDB.* TO 'ruth'@'localhost';
   FLUSH PRIVILEGES;
   ```

---

## 🔧 Configuration

Update the connection credentials in [`Main.java`](file:///home/ruza/Projects/EAD/enterprise/src/main/java/org/example/Main.java) (or [`JDBCDemo.java`](file:///home/ruza/Projects/EAD/enterprise/src/main/java/org/example/JDBCDemo.java)) to match your MySQL setup:

```java
// Database URL (host: localhost, port: 3306, database: StudentsDB)
String url = "jdbc:mysql://localhost:3306/StudentsDB";

// MySQL credentials
String username = "your_username";
String password = "your_password";
```

> [!WARNING]
> Avoid committing hardcoded passwords or sensitive credentials to public version control repositories.

---

## 🚀 Building and Running

### Option 1: Using Maven Command Line

1. **Compile the project**:
   ```bash
   mvn clean compile
   ```

2. **Run `Main`**:
   ```bash
   mvn exec:java -Dexec.mainClass="org.example.Main"
   ```

3. **Run `JDBCDemo`**:
   ```bash
   mvn exec:java -Dexec.mainClass="org.example.JDBCDemo"
   ```

### Option 2: Using an IDE (IntelliJ IDEA / Eclipse / VS Code)

1. Open the project folder in your IDE.
2. Ensure Maven imports the dependencies specified in [`pom.xml`](file:///home/ruza/Projects/EAD/enterprise/pom.xml).
3. Navigate to `src/main/java/org/example/Main.java` or `JDBCDemo.java`.
4. Right-click the file and select **Run 'Main.main()'** or **Run 'JDBCDemo.main()'**.

### Expected Output

Upon successful connection, the terminal will display:
```text
Established Connection!
```

---

## 🧠 Code Overview

The project relies on standard JDBC API components:

1. **Driver Registration**:
   ```java
   String driver = "com.mysql.cj.jdbc.Driver";
   Class.forName(driver);
   ```
   Loads the MySQL JDBC Driver into memory.

2. **Connection Initialization**:
   ```java
   Connection connection = DriverManager.getConnection(url, username, password);
   ```
   Establishes a socket connection to the database.

3. **Resource Cleanup**:
   ```java
   connection.close();
   ```
   Ensures the database connection is closed properly to release database resources.

---

## 🛠️ Troubleshooting

- **`ClassNotFoundException: com.mysql.cj.jdbc.Driver`**:
  Make sure Maven dependencies have been downloaded properly by running `mvn clean install`.
- **`CommunicationsException: Communications link failure`**:
  Ensure MySQL service is running and accessible on `localhost:3306`.
- **`SQLException: Access denied for user`**:
  Verify your MySQL username and password in the Java source file.
- **`SQLException: Unknown database 'StudentsDB'`**:
  Ensure you ran `CREATE DATABASE StudentsDB;` in MySQL before running the application.
