package catalog.angularjs.controllers;

import catalog.angularjs.generated.tables.pojos.Author;
import catalog.angularjs.generated.tables.pojos.Book;
import catalog.angularjs.model.BookModel;
import catalog.angularjs.services.CatalogService;
import catalog.angularjs.validation.ValidationErrorDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping(value = "api/")
public class MainController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private CatalogService catalogService;
    private static final Logger logger = Logger.getLogger(MainController.class);

    @RequestMapping(value = "/getBooks", method = RequestMethod.GET)
    public List<BookModel> getAllBooks(){
        List<BookModel> books = catalogService.getAllBooks();
        logger.debug(books);
        return books;
    }

    @RequestMapping(value = "/getAuthors", method = RequestMethod.GET)
    public List<Author> getAllAuthors(){
        return catalogService.getAllAuthors();
    }

    @RequestMapping(value = "/getBooksOfAuthor", method = RequestMethod.GET)
    public List<Book> getBooksOfAuthor(@RequestParam int idAuthor){
        logger.debug("api/getBooksOfAuthor?idAuthor=" + idAuthor);
        return catalogService.getBooksOfAuthors(idAuthor);
    }

    @Secured(value = { "ROLE_ADMIN" })
    @RequestMapping(value = "/addAuthor", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addAuthor(@Valid @RequestBody Author author){
        logger.debug("api/addAuthor");
        catalogService.addAuthor(author);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationErrorDTO processValidationError(MethodArgumentNotValidException ex){
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        return processFieldErrors(fieldErrors);
    }

    private ValidationErrorDTO processFieldErrors(List<FieldError> fieldErrors){
        ValidationErrorDTO validationErrorDTO = new ValidationErrorDTO();
        for(FieldError fieldError:fieldErrors){
            String message = resolveLocalizedErrorMessage(fieldError);
            validationErrorDTO.addFieldError(fieldError.getField(),message);
        }
        logger.debug("ValidationErrorDTO: "+validationErrorDTO);
        return validationErrorDTO;
    }

    private String resolveLocalizedErrorMessage(FieldError fieldError){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(fieldError,locale);
    }

    @Secured(value = { "ROLE_ADMIN" })
    @RequestMapping(value = "/deleteAuthor", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAuthor(@RequestBody String idAuthor){
        logger.debug("Author with idAuthor " + idAuthor + " will be deleted.");
        catalogService.deleteAuthor(idAuthor);
    }

    //{ "shortDescription":"Про великую депресию", "title": "Гроздья гнева", "datePublish": "1939", "authors":  [ 100 ] }
    @Secured(value = { "ROLE_ADMIN" })
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addBook(@RequestBody BookModel bookModel) {
        logger.debug("api/addBook. BookModel: " + bookModel);
        catalogService.addBook(bookModel);
    }

    @Secured(value = { "ROLE_ADMIN" })
    @RequestMapping(value = "/updateAuthor", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateAuthor(@RequestBody Author author) {
        logger.debug("api/updateAuthor. Author: " + author);
    }
}
