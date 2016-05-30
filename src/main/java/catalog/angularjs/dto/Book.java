package catalog.angularjs.dto;

import java.util.List;

/**
 * Created by Evgen on 11.11.2015.
 */
public class Book {

    private List<Author> authors;

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
