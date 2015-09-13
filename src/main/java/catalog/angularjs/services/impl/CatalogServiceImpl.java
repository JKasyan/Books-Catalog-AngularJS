package catalog.angularjs.services.impl;

import catalog.angularjs.model.Author;
import catalog.angularjs.model.Book;
import catalog.angularjs.dao.AuthorRepository;
import catalog.angularjs.dao.BookRepository;
import catalog.angularjs.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("catalogService")
public class CatalogServiceImpl implements CatalogService{

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public CatalogServiceImpl(BookRepository bookRepository,
                              AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public List<Book> getBooksOfAuthors(int id) {
        throw new RuntimeException();
    }

    @Override
    public void deleteAuthor(String id) {
        authorRepository.delete(id);
    }
}
