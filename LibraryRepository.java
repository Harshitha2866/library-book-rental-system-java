import java.util.Collection;
import java.util.HashMap;

public class LibraryRepository {

    private HashMap<Integer, Book> books;

    public LibraryRepository() {
        books = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getBookId(), book);
    }

    public Book findById(int id) {
        return books.get(id);
    }

    public Collection<Book> getAllBooks() {
        return books.values();
    }

    public boolean containsBook(int id) {
        return books.containsKey(id);
    }

    public int totalBooks() {
        return books.size();
    }
}