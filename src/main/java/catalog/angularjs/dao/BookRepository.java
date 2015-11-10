package catalog.angularjs.dao;

import java.util.List;

/**
 * Created by evgen on 30.09.15.
 */
public interface BookRepository {

    List<Book> findAll();
}
