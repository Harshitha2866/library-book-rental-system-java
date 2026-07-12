package model;

public class Book {

    private int bookId;
    private String title;
    private String author;
    private double price;
    private boolean available;

    public Book(int bookId, String title, String author, double price) {

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;

    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {

        return "Book ID : " + bookId +
                "\nTitle : " + title +
                "\nAuthor : " + author +
                "\nPrice : ₹" + price +
                "\nStatus : " + (available ? "Available" : "Rented");

    }

}