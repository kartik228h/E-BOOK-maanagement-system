import javax.swing.*;
import java.awt.event.*;

public class AddBookGUI extends JFrame {

    public AddBookGUI() {
        setTitle("Add Ebook");
        setSize(400, 350);
        setLayout(null);

        JLabel l1 = new JLabel("Title:");
        l1.setBounds(50, 50, 100, 30);
        add(l1);

        JTextField title = new JTextField();
        title.setBounds(150, 50, 150, 30);
        add(title);

        JLabel l2 = new JLabel("Author:");
        l2.setBounds(50, 100, 100, 30);
        add(l2);

        JTextField author = new JTextField();
        author.setBounds(150, 100, 150, 30);
        add(author);

        JLabel l3 = new JLabel("Price:");
        l3.setBounds(50, 150, 100, 30);
        add(l3);

        JTextField price = new JTextField();
        price.setBounds(150, 150, 150, 30);
        add(price);

        JButton btn = new JButton("Add Book");
        btn.setBounds(130, 220, 120, 40);
        add(btn);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new EbookDAO().addBook(new Ebook(
                        title.getText(),
                        author.getText(),
                        Double.parseDouble(price.getText())
                ));

                JOptionPane.showMessageDialog(null, "Book Added Successfully!");
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
