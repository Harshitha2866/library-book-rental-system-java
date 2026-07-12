package ui;

import service.Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private Library library;

    public MainFrame(Library library) {

        this.library = library;

        // Window Title
        setTitle("Smart Library System");

        // Window Size
        setSize(700, 550);

        // Open Window at Center
        setLocationRelativeTo(null);

        // Close Application
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Heading
        JLabel heading = new JLabel("SMART LIBRARY SYSTEM", JLabel.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 24));

        // Button Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));

        // Buttons
        JButton addBook = new JButton("Add Book");
        JButton searchBook = new JButton("Search Book");
        JButton rentBook = new JButton("Rent Book");
        JButton returnBook = new JButton("Return Book");
        JButton availableBooks = new JButton("Available Books");
        JButton rentedBooks = new JButton("Rented Books");
        JButton transactions = new JButton("Transaction History");
        JButton exitButton = new JButton("Exit");

        // Add Buttons to Panel
        panel.add(addBook);
        panel.add(searchBook);

        panel.add(rentBook);
        panel.add(returnBook);

        panel.add(availableBooks);
        panel.add(rentedBooks);

        panel.add(transactions);
        panel.add(exitButton);

        // Add Components to Frame
        add(heading, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        // Add Book
        addBook.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new AddBookFrame(library);

            }

        });

        // Search Book
        searchBook.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new SearchBookFrame(library);

            }

        });

        // Rent Book
        rentBook.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new RentBookFrame(library);

            }

        });

        // Return Book
        returnBook.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new ReturnBookFrame(library);

            }

        });

        // Available Books
        availableBooks.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new AvailableBooksFrame(library);

            }

        });

        rentedBooks.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new RentedBooksFrame(library);

            }

        });

        transactions.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                new TransactionHistoryFrame(library);

            }

        });

        // Exit
        exitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int choice = JOptionPane.showConfirmDialog(
                        MainFrame.this,
                        "Do you want to exit?",
                        "Exit",
                        JOptionPane.YES_NO_OPTION);

                if (choice == JOptionPane.YES_OPTION) {

                    System.exit(0);

                }

            }

        });

        // Display Window
        setVisible(true);

    }

}