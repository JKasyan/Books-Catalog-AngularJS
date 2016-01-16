package catalog.angularjs.services;


import catalog.angularjs.dto.Author;
import catalog.angularjs.dto.Book;
import catalog.angularjs.model.BookModel;

import java.util.List;

public interface CatalogService {

    List<catalog.angularjs.dto.Book> getAllBooks();
    List<Author> getAllAuthors();
    Author getAuthor(int idAuthor);
    List<Book> getBooksOfAuthors(int id);
    void addAuthor(Author author);
    void deleteAuthor(int idAuthor);
    void addBook(BookModel bookModel);
    void updateAuthor(Author author);
    void updateBook(BookModel bookModel);
    void deleteBook(int idBook);
    BookModel getBookById(int id);
}
