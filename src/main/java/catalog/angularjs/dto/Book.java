package catalog.angularjs.dto;


import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgen on 09.08.2015.
 */
public class Book {

    private int id;
    private String title;
    private String shortDescription;
    private DateTime datePublish;
//    private List<Author> authors = new ArrayList<Author>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public DateTime getDatePublish() {
        return datePublish;
    }

    public void setDatePublish(DateTime datePublish) {
        this.datePublish = datePublish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public List<Author> getAuthors() {
//        return authors;
//    }
//
//    public void setAuthors(List<Author> authors) {
//        this.authors = authors;
//    }
}
