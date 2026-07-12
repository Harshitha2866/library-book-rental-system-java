package strategy;

import model.Book;
import repository.LibraryRepository;

public interface SearchStrategy {

    Book search(LibraryRepository repository, String value);

}