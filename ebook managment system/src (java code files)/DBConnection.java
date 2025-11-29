import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/ebookdb";
    private static final String USER = "root";
    private static final String PASS = "root"; 

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.out.println("⚠ MySQL Driver JAR not found, attempting direct connection...");
            }
            
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("✓ Database Connected Successfully!");
            return con;
        }
        catch (ClassNotFoundException e) {
            System.out.println("❌ MySQL Driver Error: " + e.getMessage());
            System.out.println("Make sure mysql-connector-java JAR is in lib folder");
            return null;
        }
        catch (SQLException e) {
            System.out.println("❌ Connection Error: " + e.getMessage());
            System.out.println("\n📋 Troubleshooting:");
            System.out.println("1. Is MySQL running? (Start MySQL Server)");
            System.out.println("2. Does database 'ebookdb' exist?");
            System.out.println("3. Credentials correct? (User: root, Pass: root)");
            System.out.println("4. MySQL on localhost:3306?");
            System.out.println("\n💡 To create database, run in MySQL:");
            System.out.println("   CREATE DATABASE IF NOT EXISTS ebookdb;");
            System.out.println("   USE ebookdb;");
            System.out.println("   CREATE TABLE ebooks (id INT AUTO_INCREMENT PRIMARY KEY, title VARCHAR(255), author VARCHAR(255), price DOUBLE);");
            return null;
        }
        catch (Exception e) {
            System.out.println("❌ Unknown Error: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
