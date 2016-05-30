package catalog.angularjs.services.impl;

import catalog.angularjs.dao.AuthorRepository;
import catalog.angularjs.dao.BookRepository;
import catalog.angularjs.dto.Author;
import catalog.angularjs.dto.Book;
import catalog.angularjs.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("catalogService")
public class CatalogServiceImpl implements CatalogService {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
    public CatalogServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public List<Book> getBooksOfAuthors(int id) {
        return null;
    }

    @Override
    public void deleteAuthor(String idAuthor) {
        authorRepository.delete(idAuthor);
    }

    @Override
    @Transactional
    public void addBook(Book book) {

    }

    @Override
    public void updateAuthor(Author author) {

    }

    @Override
    public void deleteBook(String idBook) {
        bookRepository.delete(idBook);
    }

    @Override
    public Author getAuthor(String idAuthor) {
        return authorRepository.findOne(idAuthor);
    }

    @Override
    public Book getBookById(String id) {
        return bookRepository.findOne(id);
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }
}
