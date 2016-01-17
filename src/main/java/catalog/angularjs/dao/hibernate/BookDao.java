package catalog.angularjs.dao.hibernate;

import catalog.angularjs.dto.Book;
import catalog.angularjs.model.BookModel;

import java.util.List;

/**
 * Created by evgen on 16.01.16.
 */
public interface BookDao {

    List<Book> selectAll();

    List<Book> selectBooksByIdAuthor(int idAuthor);

    void deleteBook(int idBook);

    Book selectBook(int id);

    void updateBook(Book book);
}
