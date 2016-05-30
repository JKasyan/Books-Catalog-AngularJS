package catalog.angularjs.controllers;

import catalog.angularjs.dto.Book;
import catalog.angularjs.model.BookModel;
import catalog.angularjs.security.UserDetailService;
import catalog.angularjs.services.CatalogService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "api/")
public class BooksController {

    @Autowired
    private CatalogService catalogService;
    private static final Logger logger = Logger.getLogger(BooksController.class);

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> getAllBooks(Principal principal){
        logger.debug("api/books");
        logger.info("Principal: " + principal.getName());
        return catalogService.getAllBooks();
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable String id) {
        return catalogService.getBookById(id);
    }

    @RequestMapping(value = "/books/authors/{idAuthor}", method = RequestMethod.GET)
    public List<Book> getBooksOfAuthor(@PathVariable int idAuthor){
        logger.debug("/books/authors/" + idAuthor);
        return /*catalogService.getBooksOfAuthors(idAuthor)*/null;
    }


    @RequestMapping(value = "/books/{idBook}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable String idBook) {
        logger.debug("api/books/" + idBook + ". Method delete.");
        catalogService.deleteBook(idBook);
    }

    //{ "shortDescription":"Про великую депресию", "title": "Гроздья гнева", "datePublish": "1939", "authors":  [ 100 ] }
    @Secured(value = UserDetailService.ROLE_ADMIN)
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addBook(@RequestBody Book book) {
        logger.debug("api/books. Method: Post");
        catalogService.addBook(book);
    }

    //{"idBook":"11", "shortDescription": "dfdfdf", "title": "ddddd", "datePublish":1999, "authors":[11] }
    @Secured(value = UserDetailService.ROLE_ADMIN)
    @RequestMapping(value = "/books", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@RequestBody Book book) {
        logger.debug("api/books. Method: PUT");
        logger.info("Updating book: " + book);
        catalogService.updateBook(book);
    }

}
