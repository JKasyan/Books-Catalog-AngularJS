package catalog.angularjs.dao;


import catalog.angularjs.generated.tables.pojos.Author;
import catalog.angularjs.model.Book;

import java.util.List;

public interface AuthorRepository {

    List<Author> findAllAuthors();
    void addBook(String idAuthor, Book book);
}
