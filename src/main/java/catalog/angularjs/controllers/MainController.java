package catalog.angularjs.controllers;

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
public class MainController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private CatalogService catalogService;
    private static final Logger logger = Logger.getLogger(MainController.class);

    @RequestMapping(value = "/getBooks", method = RequestMethod.GET)
    public List<Book> getAllBooks(){
        List<Book> books = catalogService.getAllBooks();
        logger.debug(books);
        return books;
    }

    @RequestMapping(value = "/getAuthors", method = RequestMethod.GET)
    public List<Author> getAllAuthors(){
        return catalogService.getAllAuthors();
    }

    @RequestMapping(value = "/getBooksOfAuthor/{id}")
    public List<Book> getBooksOfAuthor(@PathVariable int id){
        return catalogService.getBooksOfAuthors(id);
    }

    @Secured(value = { "ROLE_ADMIN" })
    @RequestMapping(value = "/addAuthor", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addAuthor(@Valid @RequestBody Author author){
        logger.debug("New author: " + author);
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
        String message = messageSource.getMessage(fieldError,locale);
        return message;
    }

    @Secured(value = { "ROLE_ADMIN" })
    @RequestMapping(value = "/deleteAuthor", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAuthor(@RequestBody String id){
        logger.debug("Author with id " + id + " will be deleted.");
        catalogService.deleteAuthor(id);
    }
}
