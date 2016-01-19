package catalog.angularjs.model;

import catalog.angularjs.dto.Author;
import catalog.angularjs.dto.Book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by evgen on 02.12.15.
 */
public class AuthorModel {

    private String firstName;
    private String secondName;
    private boolean status;
    private List<BookModel> books;

    public AuthorModel() {}

    public AuthorModel(Author author) {
        this.firstName = author.getFirstName();
        this.secondName = author.getSecondName();
        this.status = author.isStatus();
        this.books = createAuthors(author.getBooks());
    }

    private List<BookModel> createAuthors(Collection<Book> books) {
        List<BookModel> bookModels = new ArrayList<>();
        books.stream().forEach(book -> {
            BookModel bookModel = new BookModel(book);
            bookModels.add(bookModel);
        });
        return bookModels;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }
}
