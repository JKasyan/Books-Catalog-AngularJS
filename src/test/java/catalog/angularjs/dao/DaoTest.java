package catalog.angularjs.dao;

import catalog.angularjs.dao.hibernate.AuthorDao;
import catalog.angularjs.dao.hibernate.BookDao;
import catalog.angularjs.dto.Author;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by evgen on 18.01.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:data_source.xml"})
@Sql(scripts = {"classpath:h2_scripts.sql"})
public class DaoTest {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger logger = Logger.getLogger(DaoTest.class);

    @Before
    public void setUp() {
        Author author = new Author();
        author.setFirstName("Ernest");
        author.setSecondName("Hemingway");
        author.setStatus(true);
        authorDao.insertAuthor(author);
    }

    @Test
    public void test() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Author author = new Author();
        author.setFirstName("Ernest");
        author.setSecondName("Hemingway");
        author.setStatus(true);
        session.save(author);
        transaction.commit();
    }

    @Test
    public void getAuthor() {
        List<Author> authors = authorDao.selectAllAuthors();
        System.out.println(authors);
    }

    @Test
    //@Sql(scripts = {"classpath:h2_new_books_and_authors.sql"})
    public void cashTest() {
        List<Author> authors = authorDao.selectAllAuthors();
        logger.info("Authors: " + authors);
        authorDao.selectAllAuthors();
//        SingletonEhCacheRegionFactory
    }

    @Test
    public void secondLevelCacheTest() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Author author = (Author)session.load(Author.class, 1);
        System.out.println(author);
        session.getTransaction().commit();
        session.close();
        /**
         *
         */
        Session session1 = sessionFactory.openSession();
        session1.beginTransaction();
        Author author1 = (Author)session1.load(Author.class, 1);
        System.out.println(author1);
        session1.getTransaction().commit();
        session1.close();
    }
}
