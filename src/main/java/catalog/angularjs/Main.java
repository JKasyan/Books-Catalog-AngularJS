package catalog.angularjs;


import catalog.angularjs.dto.Author;
import catalog.angularjs.dto.Book;
import catalog.angularjs.services.CatalogService;
import catalog.angularjs.services.impl.CatalogServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws Exception{
//        ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
//        CatalogService service = (CatalogService)context.getBean(CatalogServiceImpl.class);
//        logger.debug(service.getAllBooks());
        ObjectMapper mapper = new ObjectMapper();
        String jsonAuthor = "{\"id\": \"5\",\"name\": \"Evgen\", \"secondName\": \"Kasyan\"}";
        //String jsonBook = "{\"id\": \"5\",\"title\": \"Title\", \"shortDescription\": \"ShortDescription\", \"datePublish\": \"datePublish\"}";
        System.out.println(jsonAuthor);
        //System.out.println(jsonBook);
        Author a = mapper.readValue(jsonAuthor,Author.class);
        System.out.println(a);
        //Book b = mapper.readValue(jsonBook,Book.class);
        //System.out.println(b);
    }
}
