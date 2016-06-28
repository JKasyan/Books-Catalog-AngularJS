package catalog.angularjs.dao;


import catalog.angularjs.dto.Visitor;

import java.util.List;

/**
 * Created by evgen on 24.02.16.
 */
public interface VisitorDao {

    void save(Visitor visitor);
    List<Visitor> findAll();
}
