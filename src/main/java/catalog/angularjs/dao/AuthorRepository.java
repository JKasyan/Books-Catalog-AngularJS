package catalog.angularjs.dao;

import catalog.angularjs.dto.Author;

import java.util.List;

public interface AuthorRepository /*extends MongoRepository<Author, String>*/ {

    Author insert(Author author);
    List<Author> findAll();
    void delete(String id);
    //List<Author> selectByPattern(String pattern);
    Author findOne(String id);
    void save(Author author);
}
