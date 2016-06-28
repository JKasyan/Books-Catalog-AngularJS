package catalog.angularjs.dao.impl;

import catalog.angularjs.dao.VisitorDao;
import catalog.angularjs.dto.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 31.05.16.
 *
 * @author evgen
 */
@Repository
public class VisitorDaoImpl implements VisitorDao {

    @Autowired
    private MongoTemplate template;

    @Override
    public List<Visitor> findAll() {
        return null;
    }

    @Override
    public void save(Visitor visitor) {
        template.save(visitor);
    }
}
