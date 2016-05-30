package catalog.angularjs.dao;

import catalog.angularjs.dto.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by evgen on 30.09.15.
 */
public interface BookRepository extends MongoRepository<Book, String> {

    List<Book> findAll();
    //List<Book> selectBooksByIdAuthor(int idAuthor); TODO:
    void delete(String id);
    Book findOne(String id);
    //Book updateBook(Book book); Replaced by save()
}
