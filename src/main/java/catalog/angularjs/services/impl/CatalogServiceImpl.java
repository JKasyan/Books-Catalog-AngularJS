package catalog.angularjs.services.impl;

import catalog.angularjs.dto.Author;
import catalog.angularjs.dto.Book;
import catalog.angularjs.services.CatalogService;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgen on 09.08.2015.
 */

@Service("catalogService")
public class CatalogServiceImpl implements CatalogService{

    @Autowired
    private SessionFactory sessionFactory;
    private static final Logger logger = Logger.getLogger(CatalogServiceImpl.class);

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
        book.setDatePublish("1953");

        authors.add(author);
        books.add(book);

        author.setBooks(books);
        book.setAuthors(authors);
    }

    public List<Book> getAllBooks() {
        List<Book> books = sessionFactory.openSession().
                createQuery("from catalog.angularjs.dto.Book").list();
        logger.debug("Books: "+books);
        return books;
    }

    public List<Author> getAllAuthors() {
        return sessionFactory.openSession().
                createQuery("from catalog.angularjs.dto.Author").list();
    }

    public List<Book> getBooksOfAuthors(int id){
        return null;
    }
}
