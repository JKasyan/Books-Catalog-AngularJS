package catalog.angularjs.dao.hibernate.impl;

import catalog.angularjs.dao.hibernate.BookDao;
import catalog.angularjs.dto.Book;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by evgen on 16.01.16.
 */
@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    private static final String SELECT_BOOKS_BY_ID = "SELECT DISTINCT b " +
            "FROM catalog.angularjs.dto.Book b " +
            "INNER JOIN b.authors a " +
            "WHERE a.id = :id";

    private static final Logger logger = Logger.getLogger(BookDaoImpl.class);

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> selectAll() {
        Session session = this.sessionFactory.openSession();
        List list = session
                .createCriteria(Book.class)
                .add(Restrictions.eq("status", true))
                .list();
        logger.debug("Books: " + list);
        return list;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Book> selectBooksByIdAuthor(int idAuthor) {
        Session session = this.sessionFactory.openSession();
        Query query = session.createQuery(SELECT_BOOKS_BY_ID);
        query.setInteger("id", idAuthor);
        return query.list();
    }

    @Override
    public void deleteBook(int idBook) {
        Session session = this.sessionFactory.openSession();
        Book book = (Book)session.load(Book.class, idBook);
        if(book != null) {
            book.setStatus(false);
            session.flush();
        } else {
            throw new RuntimeException("Book with id: " + idBook + " not exists");
        }
    }

    @Override
    public Book selectBook(int id) {
        Session session = this.sessionFactory.openSession();
        Book book = (Book) session.load(Book.class, id);
        logger.debug("Book: " + book);
        return book;
    }

    @Override
    public void updateBook(Book book) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = this.sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();
            session.update(book);
            transaction.commit();
        }catch (Exception e) {
            logger.error("Error. Trying to roll back");
            try {
                if (transaction != null) {
                    transaction.rollback();
                    logger.debug("Transaction roll back");
                }
            }catch (RuntimeException ex) {
                logger.error("Could not roll back transaction: " + ex);
            }
        } finally {
            if(session != null && session.isOpen()) {
                session.close();
                logger.debug("Session closed: " + session.isOpen());
            }
        }
    }
}
