package catalog.angularjs.dao.hibernate.impl;

import catalog.angularjs.dao.hibernate.AuthorDao;
import catalog.angularjs.dto.Author;
import catalog.angularjs.dto.Book;
import catalog.angularjs.model.BookModel;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        Session session = sessionFactory.openSession();
        session.persist(author);
        logger.info("New author: " + author);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Author> selectAllAuthors() {
        Session session = this.sessionFactory.openSession();
        return session.createCriteria(Author.class)
                .add(Restrictions.eq("status", true))
                .list();
    }

    @Override
    public void delete(int idAuthor) {

    }

    @Override
    public void addBook(Book book) {
        Session session = this.sessionFactory.openSession();
        session.persist(book);
        logger.info("New book: " + book);
    }

    @Override
    public void updateAuthor(Author author) {

    }

    @Override
    public Author selectAuthor(int idAuthor) {
        Session session = this.sessionFactory.openSession();
        return (Author)session.load(Author.class, idAuthor);
    }
}
