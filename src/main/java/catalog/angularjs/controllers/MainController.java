package catalog.angularjs.controllers;

import catalog.angularjs.dto.Author;
import catalog.angularjs.dto.Book;
import catalog.angularjs.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Evgen on 09.08.2015.
 */

@RestController
public class MainController {

    @Autowired
    private CatalogService catalogService;

    @RequestMapping(value = "/getBooks", method = RequestMethod.GET)
    public List<Book> getAllBooks(){
        return catalogService.getAllBooks();
    }

    @RequestMapping(value = "/getAuthors", method = RequestMethod.GET)
    public List<Author> getAllAuthors(){
        return catalogService.getAllAuthors();
    }
}
