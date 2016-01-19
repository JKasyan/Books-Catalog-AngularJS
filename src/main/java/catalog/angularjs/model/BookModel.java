package catalog.angularjs.model;

import catalog.angularjs.dto.Author;
import catalog.angularjs.dto.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by evgen on 02.12.15.
 */
public class BookModel {

    private int idBook;
    private String shortDescription;
    private String title;
    private String datePublish;
    private List<AuthorModel> authors;

    public BookModel() {}

    public BookModel(Book book){
        this.idBook = book.getId();
        this.shortDescription = book.getShortDescription();
        this.title = book.getTitle();
        this.datePublish = book.getDatePublish();
        this.authors = createAuthors(book.getAuthors());
    }

    private List<AuthorModel> createAuthors(Collection<Author> authors) {
        List<AuthorModel> authorModels = new ArrayList<>();
        authors.stream().forEach(author -> {
            AuthorModel authorModel = new AuthorModel(author);
            authorModels.add(authorModel);
        });
        return authorModels;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AuthorModel> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorModel> authors) {
        this.authors = authors;
    }
}
