package ui;

import model.Book;
import service.Library;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AvailableBooksFrame extends JFrame {

    public AvailableBooksFrame(Library library) {

        setTitle("Available Books");

        setSize(600, 400);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columns = {
                "Book ID",
                "Title",
                "Author",
                "Price",
                "Status"
        };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        JTable table = new JTable(model);

        List<Book> books = library.getAvailableBooks();

        for (Book book : books) {

            model.addRow(new Object[]{

                    book.getBookId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getPrice(),
                    "Available"

            });

        }

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);

    }

}