package catalog.angularjs.model;

import catalog.angularjs.generated.tables.pojos.Author;

import java.util.List;

/**
 * Created by evgen on 02.12.15.
 */
public class BookModel {

    private int idBook;
    private String shortDescription;
    private String title;
    private List<Author> authors;

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
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

    @Override
    public String toString() {
        return "BookModel{" +
                "idBook=" + idBook +
                ", shortDescription='" + shortDescription + '\'' +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                '}';
    }
}
