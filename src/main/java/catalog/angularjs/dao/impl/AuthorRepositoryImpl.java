package catalog.angularjs.dao.impl;

import catalog.angularjs.dao.AuthorRepository;
import catalog.angularjs.dto.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 27.06.16.
 *
 * @author evgen
 */
@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    @Autowired
    private MongoTemplate template;

    @Override
    public Author insert(Author author) {
        return null;
    }

    @Override
    public List<Author> findAll() {
        return template.findAll(Author.class);
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Author findOne(String id) {
        return null;
    }

    @Override
    public void save(Author author) {
        template.save(author);
    }
}
