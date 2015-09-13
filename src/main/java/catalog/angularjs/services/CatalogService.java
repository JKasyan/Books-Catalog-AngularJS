package catalog.angularjs.services;

import catalog.angularjs.model.Author;
import catalog.angularjs.model.Book;

import java.util.List;

public interface CatalogService {

    List<Book> getAllBooks();
    List<Author> getAllAuthors();
    List<Book> getBooksOfAuthors(int id);
    void addAuthor(Author author);
    void deleteAuthor(String id);
}
