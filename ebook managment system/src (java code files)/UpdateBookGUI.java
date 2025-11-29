import javax.swing.*;
import java.awt.event.*;

public class UpdateBookGUI extends JFrame {

    public UpdateBookGUI() {
        setTitle("Update Book");
        setSize(400, 300);
        setLayout(null);

        JLabel l1 = new JLabel("ID:");
        l1.setBounds(50, 30, 100, 30);
        add(l1);

        JTextField id = new JTextField();
        id.setBounds(150, 30, 150, 30);
        add(id);

        JLabel l2 = new JLabel("New Title:");
        l2.setBounds(50, 80, 100, 30);
        add(l2);

        JTextField title = new JTextField();
        title.setBounds(150, 80, 150, 30);
        add(title);

        JLabel l3 = new JLabel("New Author:");
        l3.setBounds(50, 130, 100, 30);
        add(l3);

        JTextField author = new JTextField();
        author.setBounds(150, 130, 150, 30);
        add(author);

        JLabel l4 = new JLabel("New Price:");
        l4.setBounds(50, 180, 100, 30);
        add(l4);

        JTextField price = new JTextField();
        price.setBounds(150, 180, 150, 30);
        add(price);

        JButton btn = new JButton("Update");
        btn.setBounds(150, 230, 120, 40);
        add(btn);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new EbookDAO().updateBook(
                        Integer.parseInt(id.getText()),
                        title.getText(),
                        author.getText(),
                        Double.parseDouble(price.getText())
                );

                JOptionPane.showMessageDialog(null, "Book Updated!");
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
