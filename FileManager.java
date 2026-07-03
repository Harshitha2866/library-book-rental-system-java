import java.io.*;

public class FileManager {

    private static final String FILE_NAME = "books.txt";

    public static void saveBooks(LibraryRepository repository) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {

            for (Book book : repository.getAllBooks()) {

                writer.println(
                        book.getBookId() + "," +
                        book.getTitle() + "," +
                        book.getAuthor() + "," +
                        book.getPrice() + "," +
                        book.isAvailable());

            }

        } catch (IOException e) {

            System.out.println("Error saving books.");

        }

    }

    public static void loadBooks(LibraryRepository repository) {

        File file = new File(FILE_NAME);

        if (!file.exists())
            return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                Book book = new Book(

                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        Double.parseDouble(data[3])

                );

                if (!Boolean.parseBoolean(data[4])) {
                    book.setAvailable(false);
                }

                repository.addBook(book);

            }

        } catch (IOException e) {

            System.out.println("Error loading books.");

        }

    }

}