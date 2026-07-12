package strategy;

import model.Book;
import repository.LibraryRepository;

public class SearchByTitle implements SearchStrategy {

    @Override
    public Book search(LibraryRepository repository, String value) {

        for (Book book : repository.getAllBooks()) {

            if (book.getTitle().equalsIgnoreCase(value)) {

                return book;

            }

        }

        return null;

    }

}