package catalog.angularjs.controllers;

import catalog.angularjs.dto.Visitor;
import catalog.angularjs.services.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by evgen on 24.02.16.
 */
@RestController
@RequestMapping("/api")
public class VisitorsController {

    @Autowired
    private VisitorService visitorService;

    @RequestMapping("/visitors")
    public List<Visitor> getVisitors() {
        return visitorService.getVisitors();
    }
}
