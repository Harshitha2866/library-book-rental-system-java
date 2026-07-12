package ui;

import service.Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RentBookFrame extends JFrame {

    private Library library;

    private JTextField idField;

    public RentBookFrame(Library library) {

        this.library = library;

        setTitle("Rent Book");

        setSize(400, 200);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel formPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        JPanel buttonPanel = new JPanel();

        JLabel idLabel = new JLabel("Book ID");

        idField = new JTextField();

        JButton rentButton = new JButton("Rent");

        formPanel.add(idLabel);
        formPanel.add(idField);

        buttonPanel.add(rentButton);

        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        rentButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    int id = Integer.parseInt(idField.getText());

                    boolean rented = library.rentBook(id);

                    if (rented) {

                        JOptionPane.showMessageDialog(
                                RentBookFrame.this,
                                "Book Rented Successfully!");

                        idField.setText("");

                    } else {

                        JOptionPane.showMessageDialog(
                                RentBookFrame.this,
                                "Book Not Found!");

                    }

                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(
                            RentBookFrame.this,
                            "Enter a valid Book ID.");

                }

            }

        });

        setVisible(true);

    }

}