package catalog.angularjs.dao.hibernate.impl;

import catalog.angularjs.dao.hibernate.AuthorDao;
import catalog.angularjs.dto.Author;
import catalog.angularjs.dto.Book;
import catalog.angularjs.model.BookModel;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by evgen on 16.01.16.
 */
@Repository
public class AuthorDaoImpl implements AuthorDao {

    @Autowired
    private SessionFactory sessionFactory;
    private static final Logger logger = Logger.getLogger(AuthorDaoImpl.class);

    @Override
    public void insertAuthor(Author author) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = this.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.save(author);
            logger.info("New author: " + author);

        }finally {
            transaction.commit();
            logger.info("Hash session: " + session.hashCode());
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Author> selectAllAuthors() {
        Session session;
        Transaction transaction = null;
        try{
            session = this.sessionFactory.getCurrentSession();
            logger.info("Hash session: " + session.hashCode());
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(Author.class);
            criteria.add(Restrictions.eq("status", true));
            criteria.setCacheable(true);
            criteria.setCacheRegion("authors");
            return criteria.list();
        }finally {
            assert transaction != null;
            transaction.commit();
        }
    }

    @Override
    public void delete(int idAuthor) {

    }

    @Override
    public void addBook(Book book) {}

    @Override
    public void updateAuthor(Author author) {

    }

    @Override
    /**
     * first level cache
     */
    public Author selectAuthor(int idAuthor) {
        Session session = this.sessionFactory.openSession();
        Author author = (Author) session.load(Author.class, idAuthor);
        logger.debug("Author: " + author);
        Author authorCache = (Author) session.load(Author.class, idAuthor);
        logger.debug("Author: " + authorCache + ", equals links: " + (author == authorCache));
        logger.debug("Exists in cache: " + sessionFactory.getCache().containsEntity(Author.class, idAuthor));
        return author;
    }
}
