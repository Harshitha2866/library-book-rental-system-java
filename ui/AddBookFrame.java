package ui;

import model.Book;
import service.Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookFrame extends JFrame {

    private Library library;

    private JTextField idField;
    private JTextField titleField;
    private JTextField authorField;
    private JTextField priceField;

    public AddBookFrame(Library library) {

        this.library = library;

        // Window Title
        setTitle("Add Book");

        // Window Size
        setSize(400, 300);

        // Center Window
        setLocationRelativeTo(null);

        // Close Only This Window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        JPanel buttonPanel = new JPanel();

        // Labels
        JLabel idLabel = new JLabel("Book ID");
        JLabel titleLabel = new JLabel("Title");
        JLabel authorLabel = new JLabel("Author");
        JLabel priceLabel = new JLabel("Price");

        // Text Fields
        idField = new JTextField();
        titleField = new JTextField();
        authorField = new JTextField();
        priceField = new JTextField();

        // Save Button
        JButton saveButton = new JButton("Save");

        // Add Components
        formPanel.add(idLabel);
        formPanel.add(idField);

        formPanel.add(titleLabel);
        formPanel.add(titleField);

        formPanel.add(authorLabel);
        formPanel.add(authorField);

        formPanel.add(priceLabel);
        formPanel.add(priceField);

        buttonPanel.add(saveButton);

        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Save Button Action
        saveButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    int id = Integer.parseInt(idField.getText());

                    String title = titleField.getText();

                    String author = authorField.getText();

                    double price = Double.parseDouble(priceField.getText());

                    Book book = new Book(id, title, author, price);

                    boolean added = library.addBook(book);

                    if (added) {

                        JOptionPane.showMessageDialog(
                                AddBookFrame.this,
                                "Book Added Successfully!");

                        idField.setText("");
                        titleField.setText("");
                        authorField.setText("");
                        priceField.setText("");

                    } else {

                        JOptionPane.showMessageDialog(
                                AddBookFrame.this,
                                "Book ID Already Exists!");

                    }

                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(
                            AddBookFrame.this,
                            "Please enter valid details.");

                }

            }

        });

        setVisible(true);

    }

}