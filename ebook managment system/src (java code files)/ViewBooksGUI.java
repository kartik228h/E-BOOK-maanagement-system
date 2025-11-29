import javax.swing.*;
import java.util.*;

public class ViewBooksGUI extends JFrame {

    public ViewBooksGUI() {
        setTitle("All Books");
        setSize(500, 500);

        EbookDAO dao = new EbookDAO();
        List<Ebook> list = dao.getAllBooks();

        String[] col = {"ID", "Title", "Author", "Price"};
        String[][] data = new String[list.size()][4];

        int i = 0;
        for (Ebook b : list) {
            data[i][0] = b.getId() + "";
            data[i][1] = b.getTitle();
            data[i][2] = b.getAuthor();
            data[i][3] = b.getPrice() + "";
            i++;
        }

        JTable table = new JTable(data, col);
        add(new JScrollPane(table));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}
