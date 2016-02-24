package catalog.angularjs.dao;

import catalog.angularjs.generated.tables.pojos.Visitor;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by evgen on 24.02.16.
 */
public interface VisitorDao {

    void save(String ipAddress, String username);
    void save(String ipAddress, String username, Timestamp date);
    List<Visitor> selectVisitors();
}
