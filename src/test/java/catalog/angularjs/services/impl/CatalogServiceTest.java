package catalog.angularjs.services.impl;

import catalog.angularjs.model.Author;
import catalog.angularjs.model.Book;
import catalog.angularjs.dao.AuthorRepository;
import catalog.angularjs.services.CatalogService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class CatalogServiceTest {

    private AuthorRepository authorRepository;
    private CatalogService service;

    @Before
    public void setUp(){
        authorRepository = mock(AuthorRepository.class);

        service = new CatalogServiceImpl( authorRepository);
    }

//    @Test
    public void testGetAllBooks(){
        Book book1 = new Book();
        book1.setId("1");
        book1.setTitle("The old man and the see");
        book1.setShortDescription("Nice book");
        book1.setDatePublish("1953");
        List<Book> books = new ArrayList<>();
//        when(bookRepository.findAll()).thenReturn(books);
        service.getAllBooks();
//        verify(bookRepository).findAll();
    }

//    @Test
    public void testGetAllAuthors(){
        Author author1 = new Author();
        author1.setName("Ernest");
        author1.setSecondName("Hemingway");
        Author author2 = new Author();
        author2.setName("Steven");
        author2.setSecondName("King");
        List<Author> authors = new ArrayList<>();
//        when(authorRepository.findAll()).thenReturn(authors);
        service.getAllAuthors();
//        verify(authorRepository).findAll();
    }

//    @Test
    public void testNullReturnIfNoDataFound(){
        List<Book> books = null;
//        when(bookRepository.findAll()).thenReturn(books);
        List result = service.getAllBooks();
//        verify(bookRepository).findAll();
        assertEquals(null, result);
    }

}
