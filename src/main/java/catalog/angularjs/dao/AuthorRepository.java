package catalog.angularjs.dao;


import catalog.angularjs.generated.tables.pojos.Author;
import catalog.angularjs.generated.tables.pojos.Book;


import java.util.List;

public interface AuthorRepository {

    void insertAuthor(Author author);
    List<Author> selectAllAuthors();
    void addBook(String idAuthor, Book book);
}
