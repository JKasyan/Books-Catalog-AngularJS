package catalog.angularjs.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Book implements Serializable{

    @Id
    private ObjectId id;
    private String title;
    private String shortDescription;
    private String datePublish;
    @DBRef
    private List<Author> authors = new LinkedList<>();

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

    public String getDatePublish() {
        return datePublish;
    }

    public void setDatePublish(String datePublish) {
        this.datePublish = datePublish;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return String.format("Book{id=%s, title='%s', shortDescription='%s', datePublish='%s'}",
                id, title, shortDescription, datePublish);
    }
}
