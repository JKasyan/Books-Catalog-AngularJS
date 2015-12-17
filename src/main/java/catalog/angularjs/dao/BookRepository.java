package catalog.angularjs.dao;

import catalog.angularjs.dto.BookDto;
import catalog.angularjs.generated.tables.pojos.Book;
import catalog.angularjs.model.BookModel;

import java.util.List;

/**
 * Created by evgen on 30.09.15.
 */
public interface BookRepository {

    /**
     *
     * @return
     */
    List<BookModel> selectAll();

    /**
     *
     * @param idAuthor
     * @return
     */
    List<Book> selectBooksByIdAuthor(int idAuthor);

    /**
     *
     * @param idBook
     */
    void deleteBook(int idBook);

    BookModel selectBook(int id);

    void updateBook(BookModel bookModel);
}
