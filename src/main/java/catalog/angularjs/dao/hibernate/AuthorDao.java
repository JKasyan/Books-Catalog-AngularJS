package catalog.angularjs.dao.hibernate;

import catalog.angularjs.dto.Author;
import catalog.angularjs.dto.Book;
import catalog.angularjs.model.BookModel;

import java.util.List;

/**
 * Created by evgen on 16.01.16.
 */
public interface AuthorDao {


    void insertAuthor(Author author);

    List<Author> selectAllAuthors();

    void delete(int idAuthor);

    void addBook(Book bookModel);

    void updateAuthor(Author author);

    Author selectAuthor(int idAuthor);
}
