package catalog.angularjs.dao.impl;

import catalog.angularjs.dao.AuthorRepository;
import catalog.angularjs.model.Author;
import catalog.angularjs.model.Book;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("authorRepository")
public class AuthorRepositoryImpl implements AuthorRepository {

    @Autowired
    private MongoTemplate template;
    private static final Logger logger = Logger.getLogger(AuthorRepositoryImpl.class);

    @Override
    public List<Author> findAllAuthors() {
        return template.findAll(Author.class);
    }

    @Override
    public void addBook(String idAuthor, Book book) {
        Author author = template.findOne(new Query(Criteria.where("id").is(idAuthor)), Author.class);
        logger.debug("Find author: " + author);
        if(author == null) {
            throw new RuntimeException();
        }
        author.getBooks().add(book);
        template.save(author);
    }
}
