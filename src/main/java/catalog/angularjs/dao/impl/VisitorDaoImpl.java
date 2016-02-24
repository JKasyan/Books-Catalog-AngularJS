package catalog.angularjs.dao.impl;

import catalog.angularjs.dao.VisitorDao;
import org.apache.log4j.Logger;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.UUID;

import static catalog.angularjs.generated.Tables.VISITORS;

/**
 * Created by evgen on 24.02.16.
 */
@Repository("visitorDaoImpl")
public class VisitorDaoImpl implements VisitorDao {

    @Autowired
    private DSLContext create;
    private final static Logger logger = Logger.getLogger(VisitorDaoImpl.class);

    @Override
    public void save(String ip, String username) {
        create
                .insertInto(VISITORS, VISITORS.IP_ADDRESS, VISITORS.USERNAME)
                .values(ip, username)
                .execute();
    }

    @Override
    public void save(String ip, String username, Timestamp date) {
        throw new UnsupportedOperationException("Not supported");
    }
}
