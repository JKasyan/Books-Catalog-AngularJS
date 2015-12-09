package catalog.angularjs.services.impl;

import catalog.angularjs.dao.BookRepository;
import catalog.angularjs.dao.AuthorRepository;
import catalog.angularjs.generated.tables.pojos.Book;
import catalog.angularjs.generated.tables.pojos.Author;
import catalog.angularjs.model.BookModel;
import catalog.angularjs.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void deleteAuthor(int idAuthor) {
        authorRepository.delete(idAuthor);
    }

    @Override
    @Transactional
    public void addBook(BookModel bookModel) {
        authorRepository.addBook(bookModel);
    }

    @Override
    public void updateAuthor(Author author) {

    }

    @Override
    public void deleteBook(int idBook) {
        bookRepository.deleteBook(idBook);
    }
}
