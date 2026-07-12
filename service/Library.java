package service;

import database1.BookDAO;
import model.Book;
import model.Transaction;

import java.util.List;

public class Library {

    private BookDAO bookDAO;

    public Library() {

        bookDAO = new BookDAO();

    }

    // Add Book
    public boolean addBook(Book book) {

        return bookDAO.addBook(book);

    }

    // Search Book
    public Book searchBookById(int id) {

        return bookDAO.searchBookById(id);

    }

    // Rent Book
    public boolean rentBook(int id) {

        return bookDAO.rentBook(id);

    }

    // Return Book
    public boolean returnBook(int id) {

        return bookDAO.returnBook(id);

    }

    // Available Books
    public List<Book> getAvailableBooks() {

        return bookDAO.getAvailableBooks();

    }

    // Rented Books
    public List<Book> getRentedBooks() {

        return bookDAO.getRentedBooks();

    }

    // Transaction History
    public List<Transaction> getTransactions() {

        return bookDAO.getTransactions();

    }

}