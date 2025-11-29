# E-BOOK-maanagement-system
The E-Book Management System is a Java-based application that allows users to add, update, delete, and search digital books. It provides an easy interface, efficient data handling, and quick search features to manage an entire e-book collection smoothly.
Step-by-Step (Short) — Folder Structure + Running Project
1️Create This Folder Structure

Make a main project folder:

EbookManagement/
│
├── lib/              (put mysql connector jar here)
├── src/              (all .java files here)
├── bin/              (compiled .class files will go here)
└── .vscode/          (VS Code auto settings)

Inside lib/
mysql-connector-j-8.x.x.jar

Inside src/
DBConnection.java
EbookDAO.java
Ebook.java
AddBookGUI.java
DeleteBookGUI.java
UpdateBookGUI.java
ViewBooksGUI.java
MainDashboard.java   ← your main class

2️⃣ Create Database in MySQL

Run:

CREATE DATABASE ebookdb;

USE ebookdb;

CREATE TABLE ebooks(
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(100),
  author VARCHAR(100),
  price DOUBLE
);

3️⃣ Add DBConnection Code

src/DBConnection.java:

Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/ebookdb",
    "root",
    "YOUR_PASSWORD"
);

4️⃣ Compile the Code (From Project Root)

Windows:

javac -cp "lib/*" -d bin src/*.java


Linux/Mac:

javac -cp 'lib/*' -d bin src/*.java

5️⃣ Run the Main Class

Windows:

java -cp "bin;lib/*" MainDashboard


Linux/Mac:

java -cp 'bin:lib/*' MainDashboard

6️⃣ Done

Your app will open → GUI will load → MySQL will connect → everything works.
