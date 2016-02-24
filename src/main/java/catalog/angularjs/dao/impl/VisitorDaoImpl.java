package catalog.angularjs.dao.impl;

import catalog.angularjs.dao.VisitorDao;
import org.apache.log4j.Logger;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

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
    public void save(String ip) {
        create
                .insertInto(VISITORS, VISITORS.IP)
                .values(ip)
                .execute();
    }

    @Override
    public void save(String ip, Timestamp date) {
        throw new UnsupportedOperationException("Not supported");
    }
}
