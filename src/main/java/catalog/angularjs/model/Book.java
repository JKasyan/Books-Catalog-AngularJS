package catalog.angularjs.model;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Book implements Serializable{

    @Id
    private String id;
    private String title;
    private String shortDescription;
    private String datePublish;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Book{id=%s, title='%s', shortDescription='%s', datePublish='%s'}",
                id, title, shortDescription, datePublish);
    }
}
