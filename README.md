# JDBC Project – Database Connectivity in Java

## 📌 Overview

This project demonstrates how to use **JDBC (Java Database Connectivity)** to interact with a relational database.
It covers core operations like connecting to the database, inserting, updating, deleting, and retrieving data.

---

## 🎯 Objectives

- Understand JDBC architecture
- Perform CRUD operations using Java
- Connect Java application with MySQL database
- Use PreparedStatement for secure queries

---

## 🛠️ Technologies Used

- Java (JDK 8 or above)
- JDBC API
- MySQL Database
- Maven (for dependency management)
- Eclipse IDE

---

## 📂 Project Structure

```
JDBC-Project/
│── src/main/java/
│   └── com/jdbc/
│       ├── connection/
│       ├── insert/
│       ├── update/
│       ├── delete/
│       └── fetch/
│
│── src/main/resources/
│   └── db.properties
│
│── pom.xml
│── README.md
```

---

## 🔗 JDBC Workflow

1. Load Driver
2. Establish Connection
3. Create Statement
4. Execute Query
5. Process Result
6. Close Connection

---

## ⚙️ Database Configuration

Create a database in MySQL:

```sql
CREATE DATABASE jdbc_db;
```

Example table:

```sql
CREATE TABLE student (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT
);
```

---

## 🔑 Configuration File (`db.properties`)

```
url=jdbc:mysql://localhost:3306/jdbc_db
username=root
password=your_password
```

---

## 🚀 Features

### ✅ Insert Data

- Add records into database using PreparedStatement

### ✅ Update Data

- Modify existing records

### ✅ Delete Data

- Remove records from table

### ✅ Fetch Data

- Retrieve and display records

---

## 💻 Sample Code

```java
Connection con = DriverManager.getConnection(url, user, pass);

PreparedStatement ps = con.prepareStatement("INSERT INTO student VALUES (?, ?, ?)");
ps.setInt(1, 1);
ps.setString(2, "Aniket");
ps.setInt(3, 22);

ps.executeUpdate();
```

---

## ▶️ How to Run

1. Clone the repository
2. Open in Eclipse / IntelliJ
3. Configure database in `db.properties`
4. Run main class

---

## ⚠️ Important Notes

- Always close database connections
- Use PreparedStatement to avoid SQL Injection
- Do not hardcode credentials

---

## 📚 Concepts Covered

- JDBC API
- DriverManager
- Connection Interface
- Statement vs PreparedStatement
- ResultSet

---

## 👨‍💻 Author

Aniket Gudgal

---

## 📌 Conclusion

This project provides a strong foundation for working with databases in Java using JDBC. It helps in understanding backend development and real-world data handling.

---
