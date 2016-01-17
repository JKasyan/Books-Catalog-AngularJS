package catalog.angularjs.exception;

/**
 * Created by evgen on 17.01.16.
 */
public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String idBook) {
        super("Book with " + idBook + " not exists.");
    }
}
