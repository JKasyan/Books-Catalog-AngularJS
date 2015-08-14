package catalog.angularjs.controllers;

import catalog.angularjs.dto.Author;
import catalog.angularjs.dto.Book;
import catalog.angularjs.services.CatalogService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private CatalogService catalogService;
    private static final Logger logger = Logger.getLogger(MainController.class);

    @RequestMapping(value = "/getBooks", method = RequestMethod.GET)
    public List<Book> getAllBooks(){
        return catalogService.getAllBooks();
    }

    @RequestMapping(value = "/getAuthors", method = RequestMethod.GET)
    public List<Author> getAllAuthors(){
        return catalogService.getAllAuthors();
    }

    @RequestMapping(value = "/getBooksOfAuthor/{id}")
    public List<Book> getBooksOfAuthor(@PathVariable int id){
        return catalogService.getBooksOfAuthors(id);
    }

    @RequestMapping(value = "/addAuthor", method = RequestMethod.POST)
    public String addAuthor(@RequestBody Author author){
        logger.debug("New author: "+author);
        catalogService.addAuthor(author);
        return "";
    }
}
