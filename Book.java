class Book {
    public static int totalBooks = 0;
    public static final double LATE_FEE = 2.5;

    int bookId;
    String title;
    String author;
    double price;
    boolean isAvailable;

    Book() {
        this.bookId = 0;
        this.title = "Untitled";
        this.author = "Unknown";
        this.price = 0.0;
        this.isAvailable = true;
        totalBooks++;
    }

    Book(int bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true;
        totalBooks++;
    }

    void displayDetails() {
        System.out.printf(
            "ID: %d, Title: %s, Author: %s, Price: %.2f, Available: %b%n",
            bookId, title, author, price, isAvailable
        );
    }

    void rentBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been rented.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println(title + " was not rented.");
        }
    }
}
