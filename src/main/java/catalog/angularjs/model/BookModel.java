package catalog.angularjs.model;

import catalog.angularjs.generated.tables.pojos.Author;

import java.util.List;

/**
 * Created by evgen on 02.12.15.
 */
public class BookModel {

    private int idBook;
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

    @Override
    public String toString() {
        return "BookModel{" +
                "idBook=" + idBook +
                ", authors=" + authors +
                '}';
    }
}
