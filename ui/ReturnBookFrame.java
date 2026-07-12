package ui;

import service.Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnBookFrame extends JFrame {

    private Library library;

    private JTextField idField;

    public ReturnBookFrame(Library library) {

        this.library = library;

        setTitle("Return Book");

        setSize(400, 200);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel formPanel = new JPanel(new GridLayout(1, 2, 10, 10));

        JPanel buttonPanel = new JPanel();
        JLabel idLabel = new JLabel("Book ID");

        idField = new JTextField();

        JButton returnButton = new JButton("Return");

        formPanel.add(idLabel);
        formPanel.add(idField);

        buttonPanel.add(returnButton);

        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        returnButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    int id = Integer.parseInt(idField.getText());

                    boolean returned = library.returnBook(id);

                    if (returned) {

                        JOptionPane.showMessageDialog(
                                ReturnBookFrame.this,
                                "Book Returned Successfully!");

                        idField.setText("");

                    } else {

                        JOptionPane.showMessageDialog(
                                ReturnBookFrame.this,
                                "Book Not Found!");

                    }

                } catch (NumberFormatException ex) {

                    JOptionPane.showMessageDialog(
                            ReturnBookFrame.this,
                            "Enter a valid Book ID.");

                }

            }

        });

        setVisible(true);

    }

}