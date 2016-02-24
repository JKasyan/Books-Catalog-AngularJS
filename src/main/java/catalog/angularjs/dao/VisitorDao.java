package catalog.angularjs.dao;

import java.sql.Timestamp;

/**
 * Created by evgen on 24.02.16.
 */
public interface VisitorDao {

    void save(String ip);
    void save(String ip, Timestamp date);
}
