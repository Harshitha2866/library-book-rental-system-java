import java.util.ArrayList;

class Library {
    ArrayList<Book> books = new ArrayList<>();

    void addBook(Book b) {
        books.add(b);
        System.out.println("Book added successfully!");
    }

    Book searchBook(String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    void rentBook(int bookId) {
        for (Book b : books) {
            if (b.bookId == bookId) {
                b.rentBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    void returnBook(int bookId) {
        for (Book b : books) {
            if (b.bookId == bookId) {
                b.returnBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    void displayAvailableBooks() {
        for (Book b : books) {
            if (b.isAvailable) {
                b.displayDetails();
            }
        }
    }

    void displayRentedBooks() {
        for (Book b : books) {
            if (!b.isAvailable) {
                b.displayDetails();
            }
        }
    }
}
