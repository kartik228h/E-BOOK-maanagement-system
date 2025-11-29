import javax.swing.*;
import java.awt.event.*;

public class DeleteBookGUI extends JFrame {

    public DeleteBookGUI() {
        setTitle("Delete Book");
        setSize(300, 200);
        setLayout(null);

        JLabel l = new JLabel("Enter Book ID:");
        l.setBounds(30, 30, 150, 30);
        add(l);

        JTextField id = new JTextField();
        id.setBounds(130, 30, 100, 30);
        add(id);

        JButton btn = new JButton("Delete");
        btn.setBounds(80, 90, 120, 40);
        add(btn);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new EbookDAO().deleteBook(Integer.parseInt(id.getText()));
                JOptionPane.showMessageDialog(null, "Book Deleted!");
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
