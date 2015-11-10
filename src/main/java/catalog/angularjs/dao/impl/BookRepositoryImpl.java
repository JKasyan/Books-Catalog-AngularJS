package catalog.angularjs.dao.impl;

import catalog.angularjs.dao.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bookRepository")
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private MongoTemplate template;

    @Override
    public List<Book> findAll() {
        return template.findAll(Book.class);
    }
}
