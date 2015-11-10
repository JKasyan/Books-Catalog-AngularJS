package catalog.angularjs.services.impl;

import catalog.angularjs.dao.BookRepository;
import catalog.angularjs.dao.AuthorRepository;
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
//        authorRepository.save(author);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> getAllBooks() {
//        return bookRepository.findAll();
        return  null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Author> getAllAuthors() {
        return authorRepository.findAllAuthors();
    }

    @Override
    public List<Book> getBooksOfAuthors(int id) {
        throw new RuntimeException();
    }

    @Override
    public void deleteAuthor(String id) {
//        authorRepository.delete(id);
    }
}
