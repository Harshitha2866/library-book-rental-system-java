package ui;

import model.Book;
import service.Library;
import strategy.SearchById;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBookFrame extends JFrame {

    private Library library;

    private JTextField idField;

    public SearchBookFrame(Library library) {

        this.library = library;

        // Window Title
        setTitle("Search Book");

        // Window Size
        setSize(400, 200);

        // Center Window
        setLocationRelativeTo(null);

        // Close Only This Window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel formPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        JPanel buttonPanel = new JPanel();

        // Components
        JLabel idLabel = new JLabel("Book ID");

        idField = new JTextField();

        JButton searchButton = new JButton("Search");

        // Add Components
        formPanel.add(idLabel);
        formPanel.add(idField);

        buttonPanel.add(searchButton);

        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Search Button
        searchButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    int id = Integer.parseInt(idField.getText());

                    Book book = library.searchBookById(id);

                    if (book != null) {

                        JOptionPane.showMessageDialog(

                                SearchBookFrame.this,

                                book.toString()

                        );

                    }

                    else {

                        JOptionPane.showMessageDialog(

                                SearchBookFrame.this,

                                "Book Not Found."

                        );

                    }

                }

                catch (Exception ex) {

                    JOptionPane.showMessageDialog(

                            SearchBookFrame.this,

                            "Invalid Book ID."

                    );

                }

            }

        });
        setVisible(true);

    }

}