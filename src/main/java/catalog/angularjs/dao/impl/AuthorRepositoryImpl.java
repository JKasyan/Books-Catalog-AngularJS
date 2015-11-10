package catalog.angularjs.dao.impl;

import catalog.angularjs.dao.AuthorRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("authorRepository")
public class AuthorRepositoryImpl implements AuthorRepository {

    @Autowired
    private static final Logger logger = Logger.getLogger(AuthorRepositoryImpl.class);

    @Override
    public List<Author> findAllAuthors() {
        return null;
    }

    @Override
    public void addBook(String idAuthor, Book book) {

    }
}
