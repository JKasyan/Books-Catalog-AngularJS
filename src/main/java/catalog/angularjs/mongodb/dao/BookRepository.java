package catalog.angularjs.mongodb.dao;

import catalog.angularjs.dto.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String>{

}
