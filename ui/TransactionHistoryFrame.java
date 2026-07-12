package ui;

import model.Transaction;
import service.Library;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TransactionHistoryFrame extends JFrame {

    public TransactionHistoryFrame(Library library) {

        setTitle("Transaction History");

        setSize(650,400);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columns = {

                "Book ID",
                "Operation",
                "Date & Time"

        };

        DefaultTableModel model = new DefaultTableModel(columns,0);

        JTable table = new JTable(model);

        List<Transaction> transactions = library.getTransactions();

        for(Transaction transaction : transactions){

            model.addRow(new Object[]{

                    transaction.getBookId(),
                    transaction.getOperation(),
                    transaction.getDateTime()

            });

        }

        add(new JScrollPane(table),BorderLayout.CENTER);

        setVisible(true);

    }

}