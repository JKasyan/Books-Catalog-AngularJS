package catalog.angularjs.controllers;


import catalog.angularjs.Application;
import catalog.angularjs.TestUtil;
import catalog.angularjs.dto.Author;
import catalog.angularjs.dto.Book;
import catalog.angularjs.services.CatalogService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class MainControllerTest {

    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;
    @Autowired
    private CatalogService catalogServiceMock;

    private final static String TITLE = "The old man and the see";
    private final static String DATE_PUBLISH = "1953";
    private final static String DESCRIPTION = "The old man and the see";
    private final static String ID = "1";

    private final static String LENGTH_ERROR = "length must be between 2 and 45";

    private Author author;
    private Book book;

    @Before
    public void setUp(){
        author = new Author();
        book = new Book();
        author.setName("Ernest");
        author.setSecondName("Hemingway");
        book.setTitle(TITLE);
        book.setDatePublish(DATE_PUBLISH);
        book.setShortDescription(DESCRIPTION);
        book.setId(ID);
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        book.setAuthors(authors);
        List<Book> books = new ArrayList<>();
        books.add(book);
        author.setBooks(books);
        Mockito.reset();
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

//    @Test
    public void getAllBooksTest() throws Exception{
        mockMvc.perform(get("/getBooks")).
                andExpect(status().isOk()).
                andExpect(content().contentType(MediaType.APPLICATION_JSON)).
                andExpect(jsonPath("$", hasSize(1))).
                andExpect(jsonPath("$[0].id", is(ID))).
                andExpect(jsonPath("$[0].title", is(TITLE))).
                andExpect(jsonPath("$[0].shortDescription", is(DESCRIPTION))).
                andExpect(jsonPath("$[0].datePublish", is(DATE_PUBLISH)));
        verify(catalogServiceMock, times(1)).getAllBooks();
        verifyNoMoreInteractions(catalogServiceMock);
    }

    @Test
    public void addAuthorTest() throws Exception{
        author.setName("I");
        mockMvc.perform(post("/addAuthor").
                contentType(TestUtil.APPLICATION_JSON_UTF8).
                content(TestUtil.convertObjectToJsonBytes(author))).
                andExpect(status().isBadRequest()).
                andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8)).
                andExpect(jsonPath("$.fieldErrors", hasSize(1))).
                andExpect(jsonPath("$.fieldErrors[*].field", containsInAnyOrder("name"))).
                andExpect(jsonPath("$.fieldErrors[*].message", containsInAnyOrder(LENGTH_ERROR)));
    }
}
