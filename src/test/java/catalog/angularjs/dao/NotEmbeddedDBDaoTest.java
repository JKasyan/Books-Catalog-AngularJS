package catalog.angularjs.dao;

import catalog.angularjs.Application;
import catalog.angularjs.dao.hibernate.AuthorDao;
import catalog.angularjs.dao.hibernate.BookDao;
import catalog.angularjs.dto.Author;
import net.sf.ehcache.hibernate.SingletonEhCacheRegionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void cacheTest() {
        Author author = authorDao.selectAuthor(1);
        System.out.println(author);
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
        Author author1 = (Author)session.load(Author.class, 1);
        System.out.println(author1);
        session1.getTransaction().commit();
        session1.close();
//        SingletonEhCacheRegionFactory
    }
}
