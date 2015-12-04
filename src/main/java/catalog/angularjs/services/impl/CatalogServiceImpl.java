package catalog.angularjs.services.impl;

import catalog.angularjs.dao.BookRepository;
import catalog.angularjs.dao.AuthorRepository;
import catalog.angularjs.generated.tables.pojos.Book;
import catalog.angularjs.generated.tables.pojos.Author;
import catalog.angularjs.model.BookModel;
import catalog.angularjs.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("catalogService")
public class CatalogServiceImpl implements CatalogService{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
    public CatalogServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private int getNextAuthor(String collectionName){
        return 0;
    }

    @Override
    public void addAuthor(Author author) {
        authorRepository.insertAuthor(author);
    }

    @Override
    public List<BookModel> getAllBooks() {
        return bookRepository.selectAll();
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.selectAllAuthors();
    }

    @Override
    public List<Book> getBooksOfAuthors(int id) {
        return bookRepository.selectBooksByIdAuthor(id);
    }

    @Override
    public void deleteAuthor(String id) {
//        authorRepository.delete(id);
    }
}
