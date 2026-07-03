import java.util.ArrayList;
import java.util.List;

public class Library {

    private LibraryRepository repository;
    private List<Transaction> history;

    public Library() {

        repository = new LibraryRepository();
        history = new ArrayList<>();

        FileManager.loadBooks(repository);

    }

    public void addBook(Book book) {

        if (repository.containsBook(book.getBookId())) {

            System.out.println("Book ID already exists.");
            return;

        }

        repository.addBook(book);

        FileManager.saveBooks(repository);

        System.out.println("Book added successfully.");

    }

    public Book search(SearchStrategy strategy, String value) {

        return strategy.search(repository, value);

    }

    public void rentBook(int id) {

        Book book = repository.findById(id);

        if (book == null) {

            System.out.println("Book not found.");
            return;

        }

        if (!book.isAvailable()) {

            System.out.println("Book already rented.");
            return;

        }

        book.setAvailable(false);

        history.add(new Transaction(id, "RENT"));

        FileManager.saveBooks(repository);

        System.out.println("Book rented successfully.");

    }

    public void returnBook(int id) {

        Book book = repository.findById(id);

        if (book == null) {

            System.out.println("Book not found.");
            return;

        }

        if (book.isAvailable()) {

            System.out.println("Book is already available.");
            return;

        }

        book.setAvailable(true);

        history.add(new Transaction(id, "RETURN"));

        FileManager.saveBooks(repository);

        System.out.println("Book returned successfully.");

    }

    public void displayAvailableBooks() {

        boolean found = false;

        for (Book book : repository.getAllBooks()) {

            if (book.isAvailable()) {

                System.out.println("--------------------------------");
                System.out.println(book);

                found = true;

            }

        }

        if (!found) {

            System.out.println("No available books.");

        }

    }

    public void displayRentedBooks() {

        boolean found = false;

        for (Book book : repository.getAllBooks()) {

            if (!book.isAvailable()) {

                System.out.println("--------------------------------");
                System.out.println(book);

                found = true;

            }

        }

        if (!found) {

            System.out.println("No rented books.");

        }

    }

    public void displayTransactions() {

        if (history.isEmpty()) {

            System.out.println("No transactions yet.");
            return;

        }

        for (Transaction transaction : history) {

            System.out.println(transaction);

        }

    }

    public int getTotalBooks() {

        return repository.totalBooks();

    }

}
