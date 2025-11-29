import javax.swing.*;
import java.awt.event.*;
public class MainDashboard extends JFrame {
    public MainDashboard() {
        setTitle("Ebook Management System");
        setSize(400, 400);
        setLayout(null);

        JButton b1 = new JButton("Add Book");
        b1.setBounds(100, 50, 200, 40);
        add(b1);

        JButton b2 = new JButton("View Books");
        b2.setBounds(100, 110, 200, 40);
        add(b2);

        JButton b3 = new JButton("Delete Book");
        b3.setBounds(100, 170, 200, 40);
        add(b3);

        JButton b4 = new JButton("Update Book");
        b4.setBounds(100, 230, 200, 40);
        add(b4);

        b1.addActionListener(e -> new AddBookGUI());
        b2.addActionListener(e -> new ViewBooksGUI());
        b3.addActionListener(e -> new DeleteBookGUI());
        b4.addActionListener(e -> new UpdateBookGUI());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainDashboard();
    }
}
