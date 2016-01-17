package catalog.angularjs.dao.hibernate.impl;

import catalog.angularjs.dao.hibernate.AuthorDao;
import catalog.angularjs.dto.Author;
import catalog.angularjs.model.BookModel;
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

    @Override
    public void insertAuthor(Author author) {

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
    public void addBook(BookModel bookModel) {

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
