package catalog.angularjs.dao;

import catalog.angularjs.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String>{

}
