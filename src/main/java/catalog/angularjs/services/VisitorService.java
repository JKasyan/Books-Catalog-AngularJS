package catalog.angularjs.services;

import catalog.angularjs.generated.tables.pojos.Visitor;

import java.util.List;

/**
 * Created by evgen on 24.02.16.
 */
public interface VisitorService {

    List<Visitor> getVisitors();
}
