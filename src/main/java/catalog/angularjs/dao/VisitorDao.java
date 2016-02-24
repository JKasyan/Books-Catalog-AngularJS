package catalog.angularjs.dao;

import java.sql.Timestamp;

/**
 * Created by evgen on 24.02.16.
 */
public interface VisitorDao {

    void save(String ipAddress, String username);
    void save(String ipAddress, String username, Timestamp date);
}
