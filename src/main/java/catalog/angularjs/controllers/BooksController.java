package catalog.angularjs.controllers;

import catalog.angularjs.generated.tables.pojos.Book;
import catalog.angularjs.model.BookModel;
import catalog.angularjs.security.UserDetailService;
import catalog.angularjs.services.CatalogService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/")
public class BooksController {

    @Autowired
    private CatalogService catalogService;
    private static final Logger logger = Logger.getLogger(BooksController.class);

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<BookModel> getAllBooks(){
        logger.debug("api/books");
        return catalogService.getAllBooks();
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public BookModel getBookById(@PathVariable int id) {
        return catalogService.getBookById(id);
    }

    @RequestMapping(value = "/books/authors/{idAuthor}", method = RequestMethod.GET)
    public List<Book> getBooksOfAuthor(@PathVariable int idAuthor){
        logger.debug("/books/authors/" + idAuthor);
        return catalogService.getBooksOfAuthors(idAuthor);
    }

    @Secured(value = UserDetailService.ROLE_ADMIN)
    @RequestMapping(value = "/books/{idBook}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable int idBook) {
        logger.debug("api/books/" + idBook + ". Method delete.");
        catalogService.deleteBook(idBook);
    }

    //{ "shortDescription":"Про великую депресию", "title": "Гроздья гнева", "datePublish": "1939", "authors":  [ 100 ] }
    @Secured(value = UserDetailService.ROLE_ADMIN)
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addBook(@RequestBody BookModel bookModel) {
        logger.debug("api/books. Method: Post");
        catalogService.addBook(bookModel);
    }

    //{"idBook":"11", "shortDescription": "dfdfdf", "title": "ddddd", "datePublish":1999, "authors":[11] }
    @Secured(value = UserDetailService.ROLE_ADMIN)
    @RequestMapping(value = "/books", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateBook(@RequestBody BookModel bookModel) {
        logger.debug("api/books. Method: PUT");
        logger.info("Updating book: " + bookModel);
        catalogService.updateBook(bookModel);
    }

}
