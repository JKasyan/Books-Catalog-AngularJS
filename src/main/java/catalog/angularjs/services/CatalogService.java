package catalog.angularjs.services;

import catalog.angularjs.generated.tables.pojos.Author;
import catalog.angularjs.generated.tables.pojos.Book;
import catalog.angularjs.model.BookModel;

import java.util.List;

public interface CatalogService {

    List<BookModel> getAllBooks();
    List<Author> getAllAuthors();
    List<Book> getBooksOfAuthors(int id);
    void addAuthor(Author author);
    void deleteAuthor(int idAuthor);
    void addBook(BookModel bookModel);
    void updateAuthor(Author author);
    void deleteBook(int idBook);
}
