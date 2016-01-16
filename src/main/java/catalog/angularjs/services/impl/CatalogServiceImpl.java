package catalog.angularjs.services.impl;


import catalog.angularjs.dao.hibernate.AuthorDao;
import catalog.angularjs.dao.hibernate.BookDao;
import catalog.angularjs.dto.Author;
import catalog.angularjs.dto.Book;
import catalog.angularjs.model.BookModel;
import catalog.angularjs.services.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("catalogService")
public class CatalogServiceImpl implements CatalogService{

    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private BookDao bookDao;

    @Override
    public void addAuthor(Author author) {
        authorDao.insertAuthor(author);
    }

    @Override
    public List<catalog.angularjs.dto.Book> getAllBooks() {
        return bookDao.selectAll();
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorDao.selectAllAuthors();
    }

    @Override
    public List<Book> getBooksOfAuthors(int id) {
        return bookDao.selectBooksByIdAuthor(id);
    }

    @Override
    public void deleteAuthor(int idAuthor) {
        authorDao.delete(idAuthor);
    }

    @Override
    @Transactional
    public void addBook(BookModel bookModel) {
        authorDao.addBook(bookModel);
    }

    @Override
    public void updateAuthor(Author author) {
        authorDao.updateAuthor(author);
    }

    @Override
    public void deleteBook(int idBook) {
        bookDao.deleteBook(idBook);
    }

    @Override
    public Author getAuthor(int idAuthor) {
        return authorDao.selectAuthor(idAuthor);
    }

    @Override
    public BookModel getBookById(int id) {
        return bookDao.selectBook(id);
    }

    @Override
    public void updateBook(BookModel bookModel) {
        bookDao.updateBook(bookModel);
    }
}
