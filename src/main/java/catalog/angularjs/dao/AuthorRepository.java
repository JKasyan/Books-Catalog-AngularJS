package catalog.angularjs.dao;


import catalog.angularjs.generated.tables.pojos.Author;
import catalog.angularjs.generated.tables.pojos.Book;
import catalog.angularjs.model.BookModel;


import java.util.List;

public interface AuthorRepository {

    void insertAuthor(Author author);
    List<Author> selectAllAuthors();
    void addBook(BookModel bookModel);
    void updateAuthor(Author author);
    void delete(int idAuthor);
}
