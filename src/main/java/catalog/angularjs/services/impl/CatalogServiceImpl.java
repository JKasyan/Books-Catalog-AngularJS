package catalog.angularjs.services.impl;

import catalog.angularjs.dto.Author;
import catalog.angularjs.dto.Book;
import catalog.angularjs.services.CatalogService;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgen on 09.08.2015.
 */

@Service("catalogService")
public class CatalogServiceImpl implements CatalogService{

    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    {
        Author author = new Author();
        author.setId(1);
        author.setName("Ernest");
        author.setSecondName("Hamingway");
        Book book = new Book();
        book.setId(1);
        book.setShortDescription("Very cool book");
        book.setTitle("The old man and the see");
        book.setDatePublish(new DateTime());

        authors.add(author);
        books.add(book);

//        author.setBooks(books);
//        book.setAuthors(authors);
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public List<Author> getAllAuthors() {
        return authors;
    }
}