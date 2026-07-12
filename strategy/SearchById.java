package strategy;

import model.Book;
import repository.LibraryRepository;

public class SearchById implements SearchStrategy {

    @Override
    public Book search(LibraryRepository repository, String value) {

        try {

            int id = Integer.parseInt(value);

            return repository.findById(id);

        }
        catch (NumberFormatException e) {

            return null;

        }

    }

}