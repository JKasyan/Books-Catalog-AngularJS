package catalog.angularjs.dao;

import catalog.angularjs.dto.BookDto;
import catalog.angularjs.generated.tables.pojos.Book;

import java.util.List;

/**
 * Created by evgen on 30.09.15.
 */
public interface BookRepository {

    List<Book> selectAll();
    List<Book> selectBooksByIdAuthor(int idAuthor);
}
