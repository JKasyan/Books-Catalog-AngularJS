package catalog.angularjs.dao;

import catalog.angularjs.Application;
import catalog.angularjs.dao.hibernate.AuthorDao;
import catalog.angularjs.dao.hibernate.BookDao;
import catalog.angularjs.dto.Author;
import catalog.angularjs.dto.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by evgen on 19.01.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class NotEmbeddedDBDaoTest {

    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private BookDao bookDao;

    @Test
    public void cacheTest() {
        Author author = authorDao.selectAuthor(1);
        System.out.println(author);
    }

    @Test
    public void secondLevelCacheTest() {
        List<Book> books = bookDao.selectAll();
        System.out.println(books);
    }
}
