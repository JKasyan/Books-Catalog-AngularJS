package catalog.angularjs.services.impl;

import catalog.angularjs.dao.VisitorDao;
import catalog.angularjs.dto.Visitor;
import catalog.angularjs.services.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by evgen on 24.02.16.
 */
@Service
public class VisitorServiceImpl implements VisitorService {

    //@Autowired
    //private VisitorDao visitorDao;

    @Override
    public List<Visitor> getVisitors() {
        return null;
    }
}
