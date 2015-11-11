package catalog.angularjs.model;

import catalog.angularjs.generated.tables.pojos.*;
import catalog.angularjs.generated.tables.pojos.Author;

/**
 * Created by Evgen on 11.11.2015.
 */
public class BookModel {

    private Book book;
    private Author authors[];

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }
}
