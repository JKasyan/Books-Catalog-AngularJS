package catalog.angularjs.dao;


import catalog.angularjs.dto.Visitor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by evgen on 24.02.16.
 */
public interface VisitorDao /*extends MongoRepository<Visitor, String>*/ {

    Visitor save(Visitor visitor);
    List<Visitor> selectAll();
}
