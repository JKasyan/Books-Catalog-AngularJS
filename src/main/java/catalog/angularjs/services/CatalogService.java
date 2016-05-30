package catalog.angularjs.services;

import catalog.angularjs.dto.Author;
import catalog.angularjs.dto.Book;

import java.util.List;

public interface CatalogService {

    List<Book> getAllBooks();
    List<Author> getAllAuthors();
    Author getAuthor(String idAuthor);
    List<Book> getBooksOfAuthors(int id);
    void addAuthor(Author author);
    void deleteAuthor(String idAuthor);
    void addBook(Book book);
    void updateAuthor(Author author);
    void updateBook(Book book);
    void deleteBook(String idBook);
    Book getBookById(String id);
}
