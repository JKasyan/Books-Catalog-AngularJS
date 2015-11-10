package catalog.angularjs.services;

import java.util.List;

public interface CatalogService {

    List<Book> getAllBooks();
    List<Author> getAllAuthors();
    List<Book> getBooksOfAuthors(int id);
    void addAuthor(Author author);
    void deleteAuthor(String id);
}
