package catalog.angularjs.dao;

import catalog.angularjs.dto.Author;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;

/**
 * Created by evgen on 11.08.15.
 */
public interface AuthorRepository extends MongoRepository<Author, String>{

    Author findBySecondName(String secondName);
}
