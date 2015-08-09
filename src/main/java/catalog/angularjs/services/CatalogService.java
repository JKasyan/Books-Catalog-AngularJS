package catalog.angularjs.services;

import catalog.angularjs.dto.Author;
import catalog.angularjs.dto.Book;

import java.util.List;

/**
 * Created by Evgen on 09.08.2015.
 */
public interface CatalogService {

    List<Book> getAllBooks();
    List<Author> getAllAuthors();
}
