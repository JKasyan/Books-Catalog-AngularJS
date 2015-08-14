package catalog.angularjs.dao.impl;

import catalog.angularjs.dao.AuthorDao;
import catalog.angularjs.dto.Author;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "authorDao")
public class AuthorDaoImpl implements AuthorDao{

    @Autowired
    private SessionFactory sessionFactory;
    private static final Logger logger = Logger.getLogger(AuthorDaoImpl.class);

    @Override
    public void insertAuthor(Author author) {
        logger.debug("Inserting new author: " + author);
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(author);
        logger.debug("Success inserting");
        transaction.commit();
    }

    @Override
    public List<Author> selectAll() {
        return sessionFactory.openSession().
                createQuery("from catalog.angularjs.dto.Author").list();
    }
}
