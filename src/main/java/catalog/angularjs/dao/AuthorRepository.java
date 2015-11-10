package catalog.angularjs.dao;

import java.util.List;

public interface AuthorRepository {

    List<Author> findAllAuthors();
    void addBook(String idAuthor, Book book);
}
