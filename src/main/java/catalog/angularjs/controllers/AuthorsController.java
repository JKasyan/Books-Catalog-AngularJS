package catalog.angularjs.controllers;

import catalog.angularjs.dto.Author;
import catalog.angularjs.security.UserDetailService;
import catalog.angularjs.services.CatalogService;
import catalog.angularjs.validation.ValidationErrorDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
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

/**
 * Created by evgen on 11.12.15.
 */
@RestController
@RequestMapping(value = "api/")
public class AuthorsController {

    @Autowired
    private CatalogService catalogService;
    private static final Logger logger = Logger.getLogger(BooksController.class);

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public List<Author> getAllAuthors(){
        List<Author> authors = catalogService.getAllAuthors();
        return authors;
    }

    @RequestMapping(value = "/authors/{idAuthor}", method = RequestMethod.GET)
    public ObjectMapper getAuthor(@PathVariable int idAuthor) {
        logger.debug("api/authors/" + idAuthor);
        Author author = catalogService.getAuthor(idAuthor);
        return null;
    }

    @Secured(value = UserDetailService.ROLE_ADMIN)
    @RequestMapping(value = "/authors", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addAuthor(@Valid @RequestBody Author author){
        logger.debug("api/addAuthor");
        catalogService.addAuthor(author);
    }

    @Secured(value = UserDetailService.ROLE_ADMIN)
    @RequestMapping(value = "/authors/{idAuthor}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAuthor(@PathVariable int idAuthor){
        logger.debug("Author with idAuthor " + idAuthor + " will be deleted.");
        catalogService.deleteAuthor(idAuthor);
    }

    @Secured(value = UserDetailService.ROLE_ADMIN)
    @RequestMapping(value = "/authors", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateAuthor(@RequestBody Author author) {
        logger.debug("api/authors. Update author: " + author);
        catalogService.updateAuthor(author);
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
}
