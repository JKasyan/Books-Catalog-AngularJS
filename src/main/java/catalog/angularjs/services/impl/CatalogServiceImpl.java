package catalog.angularjs.services.impl;

import catalog.angularjs.dto.Author;
import catalog.angularjs.dto.Book;
import catalog.angularjs.mongodb.dao.AuthorRepository;
import catalog.angularjs.mongodb.dao.BookRepository;
import catalog.angularjs.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public List<Book> getBooksOfAuthors(int id) {
        throw new RuntimeException();
    }
}
