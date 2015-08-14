package catalog.angularjs.services.impl;

import catalog.angularjs.dao.AuthorDao;
import catalog.angularjs.dao.BookDao;
import catalog.angularjs.dto.Author;
import catalog.angularjs.dto.Book;
import catalog.angularjs.services.CatalogService;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("catalogService")
public class CatalogServiceImpl implements CatalogService{

    @Autowired
    private SessionFactory sessionFactory;
    private static final Logger logger = Logger.getLogger(CatalogServiceImpl.class);
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private BookDao bookDao;

    public List<Book> getAllBooks() {
        return bookDao.selectAllBooks();
    }

    public List<Author> getAllAuthors() {
        return authorDao.selectAll();
    }

    public List<Book> getBooksOfAuthors(int id){
        return null;
    }

    @Override
    public void addAuthor(Author author) {
        authorDao.insertAuthor(author);
    }
}
