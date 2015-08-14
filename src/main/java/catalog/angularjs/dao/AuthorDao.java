package catalog.angularjs.dao;

import catalog.angularjs.dto.Author;

import java.util.List;

public interface AuthorDao {

    void insertAuthor(Author author);
    List<Author> selectAll();
}
