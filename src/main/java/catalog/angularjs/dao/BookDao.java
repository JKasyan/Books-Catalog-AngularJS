package catalog.angularjs.dao;

import catalog.angularjs.dto.Book;

import java.util.List;

public interface BookDao {

    List<Book> selectAllBooks();
}
