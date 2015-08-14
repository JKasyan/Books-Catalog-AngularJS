package catalog.angularjs.dao.impl;

import catalog.angularjs.dao.BookDao;
import catalog.angularjs.dto.Book;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "bookDao")
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;
    private static final Logger logger = Logger.getLogger(BookDaoImpl.class);

    @Override
    public List<Book> selectAllBooks() {
        return sessionFactory.openSession().
                createQuery("from catalog.angularjs.dto.Book").list();
    }
}
