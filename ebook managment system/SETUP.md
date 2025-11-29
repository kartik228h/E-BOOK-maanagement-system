# Ebook Management System - Setup Guide

## ❌ Connection Issues - Solution:

### Step 1: Download MySQL Connector JAR
1. Go to https://dev.mysql.com/downloads/connector/j/
2. Download **mysql-connector-java-8.0.33.jar** (or latest version)
3. Place it in the `lib/` folder of your project

### Step 2: Setup MySQL Database
Run these commands in MySQL:

```sql
CREATE DATABASE IF NOT EXISTS ebookdb;

USE ebookdb;

CREATE TABLE ebooks (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL
);

-- Optional: Insert sample data
INSERT INTO ebooks (title, author, price) VALUES 
('The Java Programming Language', 'James Gosling', 49.99),
('Clean Code', 'Robert C. Martin', 39.99);
```

### Step 3: Compile and Run
```powershell
cd src
javac -cp ".;../lib/*" *.java
java -cp ".;../lib/*" MainDashboard
```

## If still getting NULL connection:

1. **Check MySQL is running** - Open MySQL Workbench or command line
2. **Verify credentials** - Username: `root`, Password: `root`
3. **Check port** - MySQL must be running on port 3306
4. **Verify database exists** - Run `SHOW DATABASES;` in MySQL

### Error Messages will now show:
- ✓ Connection successful
- ❌ Driver not found (add JAR to lib)
- ❌ Connection refused (MySQL not running)
- ❌ Database doesn't exist
