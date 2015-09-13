package catalog.angularjs.dao;

import catalog.angularjs.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface AuthorRepository extends MongoRepository<Author, String> {

}
