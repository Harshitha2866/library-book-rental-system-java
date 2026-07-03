public interface SearchStrategy {

    Book search(LibraryRepository repository, String value);

}