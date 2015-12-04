package catalog.angularjs.dao;

import catalog.angularjs.dto.BookDto;
import catalog.angularjs.generated.tables.pojos.Book;
import catalog.angularjs.model.BookModel;

import java.util.List;

/**
 * Created by evgen on 30.09.15.
 */
public interface BookRepository {

    List<BookModel> selectAll();
    List<Book> selectBooksByIdAuthor(int idAuthor);
    List<BookModel> selectAll2();
}
