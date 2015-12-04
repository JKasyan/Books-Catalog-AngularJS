package catalog.angularjs.dto;

import catalog.angularjs.generated.tables.pojos.*;
import catalog.angularjs.generated.tables.pojos.Author;

import java.util.List;

/**
 * Created by Evgen on 11.11.2015.
 */
public class BookDto {

    private Book book;
    private List<Author> authors;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
