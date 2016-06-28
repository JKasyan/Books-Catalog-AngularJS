package catalog.angularjs.dto;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Evgen on 11.11.2015.
 */
@Document(collection = "book")
public class Book {

    private String id;
    private String title;


}
