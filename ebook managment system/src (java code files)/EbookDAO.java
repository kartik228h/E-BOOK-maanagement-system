import java.sql.*;
import java.util.*;

public class EbookDAO {

    public void addBook(Ebook book) {
        try {
            Connection con = DBConnection.getConnection();
            if (con == null) {
                System.out.println("❌ Cannot add book: Database connection failed");
                return;
            }
            String sql = "INSERT INTO ebooks(title, author, price) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setDouble(3, book.getPrice());

            ps.executeUpdate();
            ps.close();
            con.close();
            System.out.println("✓ Book added: " + book.getTitle());
        }
        catch (Exception e) { 
            System.out.println("❌ Error adding book: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Ebook> getAllBooks() {
        List<Ebook> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();
            if (con == null) {
                System.out.println("❌ Cannot fetch books: Database connection failed");
                return list;
            }
            String sql = "SELECT * FROM ebooks";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Ebook(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getDouble("price")
                ));
            }
            rs.close();
            ps.close();
            con.close();
            System.out.println("✓ Fetched " + list.size() + " books");
        }
        catch (Exception e) { 
            System.out.println("❌ Error fetching books: " + e.getMessage());
            e.printStackTrace();
        }

        return list;
    }

    public void deleteBook(int id) {
        try {
            Connection con = DBConnection.getConnection();
            if (con == null) {
                System.out.println("❌ Cannot delete book: Database connection failed");
                return;
            }
            String sql = "DELETE FROM ebooks WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            con.close();
            System.out.println("✓ Book deleted with ID: " + id);
        }
        catch (Exception e) { 
            System.out.println("❌ Error deleting book: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void updateBook(int id, String title, String author, double price) {
        try {
            Connection con = DBConnection.getConnection();
            if (con == null) {
                System.out.println("❌ Cannot update book: Database connection failed");
                return;
            }
            String sql = "UPDATE ebooks SET title=?, author=?, price=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, title);
            ps.setString(2, author);
            ps.setDouble(3, price);
            ps.setInt(4, id);

            ps.executeUpdate();
            ps.close();
            con.close();
            System.out.println("✓ Book updated with ID: " + id);
        }
        catch (Exception e) { 
            System.out.println("❌ Error updating book: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
