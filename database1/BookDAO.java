package database1;

import model.Book;
import model.Transaction;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class BookDAO {

    public boolean addBook(Book book) {

        String sql = "INSERT INTO Books(book_id, title, author, price, available) VALUES (?, ?, ?, ?, ?)";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, book.getBookId());
            statement.setString(2, book.getTitle());
            statement.setString(3, book.getAuthor());
            statement.setDouble(4, book.getPrice());
            statement.setBoolean(5, book.isAvailable());

            statement.executeUpdate();

            statement.close();
            connection.close();

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

    }

    public Book searchBookById(int id) {

        String sql = "SELECT * FROM Books WHERE book_id = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            var result = statement.executeQuery();

            if (result.next()) {

                Book book = new Book(

                        result.getInt("book_id"),
                        result.getString("title"),
                        result.getString("author"),
                        result.getDouble("price")

                );

                book.setAvailable(result.getBoolean("available"));

                connection.close();

                return book;

            }

            connection.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;

    }

    public boolean rentBook(int id) {

        String sql = "UPDATE Books SET available = false WHERE book_id = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {

                PreparedStatement transactionStatement = connection.prepareStatement(
                        "INSERT INTO Transactions(book_id, operation) VALUES(?, ?)");

                transactionStatement.setInt(1, id);
                transactionStatement.setString(2, "RENT");

                transactionStatement.executeUpdate();

                transactionStatement.close();

            }

            statement.close();
            connection.close();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

    }

    public boolean returnBook(int id) {

        String sql = "UPDATE Books SET available = true WHERE book_id = ?";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {

                PreparedStatement transactionStatement = connection.prepareStatement(
                        "INSERT INTO Transactions(book_id, operation) VALUES(?, ?)");

                transactionStatement.setInt(1, id);
                transactionStatement.setString(2, "RETURN");

                transactionStatement.executeUpdate();

                transactionStatement.close();

            }

            statement.close();
            connection.close();

            return rows > 0;

        } catch (Exception e) {

            e.printStackTrace();

            return false;

        }

    }

    public List<Book> getAvailableBooks() {

        List<Book> books = new ArrayList<>();

        String sql = "SELECT * FROM Books WHERE available = true";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                Book book = new Book(
                        result.getInt("book_id"),
                        result.getString("title"),
                        result.getString("author"),
                        result.getDouble("price"));

                book.setAvailable(true);

                books.add(book);

            }

            connection.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return books;

    }

    public List<Book> getRentedBooks() {

        List<Book> books = new ArrayList<>();

        String sql = "SELECT * FROM Books WHERE available = false";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                Book book = new Book(

                        result.getInt("book_id"),
                        result.getString("title"),
                        result.getString("author"),
                        result.getDouble("price")

                );

                book.setAvailable(false);

                books.add(book);

            }

            connection.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return books;

    }

    public List<Transaction> getTransactions() {

        List<Transaction> transactions = new ArrayList<>();

        String sql = "SELECT * FROM Transactions";

        try {

            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            while (result.next()) {

                Transaction transaction = new Transaction(
                        result.getInt("book_id"),
                        result.getString("operation"));

                transactions.add(transaction);

            }

            result.close();
            statement.close();
            connection.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return transactions;

    }

}