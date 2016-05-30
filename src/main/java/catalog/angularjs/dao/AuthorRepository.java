package catalog.angularjs.dao;

import catalog.angularjs.dto.Author;
import catalog.angularjs.dto.Book;
import catalog.angularjs.model.BookModel;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;

public interface AuthorRepository extends MongoRepository<Author, String> {

    Author insert(Author author);
    List<Author> findAll();
    void delete(String id);
    //List<Author> selectByPattern(String pattern);
    Author findOne(String id);
}
