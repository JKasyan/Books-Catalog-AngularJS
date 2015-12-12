package catalog.angularjs.model;

import java.util.Arrays;
import java.util.List;

/**
 * Created by evgen on 02.12.15.
 */
public class BookModel {

    private int idBook;
    private String shortDescription;
    private String title;
    private String datePublish;
    private String[] authors;

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDatePublish() {
        return datePublish;
    }

    public void setDatePublish(String datePublish) {
        this.datePublish = datePublish;
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "idBook=" + idBook +
                ", shortDescription='" + shortDescription + '\'' +
                ", title='" + title + '\'' +
                ", authors=" + Arrays.toString(authors) +
                '}';
    }
}
