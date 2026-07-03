import java.time.LocalDateTime;

public class Transaction {

    private int bookId;
    private String operation;
    private LocalDateTime dateTime;

    public Transaction(int bookId, String operation) {
        this.bookId = bookId;
        this.operation = operation;
        this.dateTime = LocalDateTime.now();
    }

    public int getBookId() {
        return bookId;
    }

    public String getOperation() {
        return operation;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return dateTime + " : Book " + bookId + " -> " + operation;
    }
}