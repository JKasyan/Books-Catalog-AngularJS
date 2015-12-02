package catalog.angularjs.dao;

import catalog.angularjs.Application;
import catalog.angularjs.generated.tables.pojos.Author;
import catalog.angularjs.generated.tables.pojos.Book;
import catalog.angularjs.model.BookModel;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Record4;
import org.jooq.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static catalog.angularjs.generated.Tables.*;
/**
 * Created by evgen on 01.12.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class QueryTest {

    @Autowired
    private DSLContext create;

    @Test
    public void leftOuterJoinTest() {
        Result<Record> fetch = create
                .select()
                .from(AUTHOR)
                .leftOuterJoin(AUTHOR_BOOK)
                .on(AUTHOR_BOOK.ID_AUTHOR.equal(AUTHOR.ID_AUTHOR)).fetch();
        System.out.println(fetch);
    }

    @Test
    public void test() {
        List<Book> books = create
                .select()
                .from(BOOK)
                .where(BOOK.ID_BOOK.equal(2))
                .fetchInto(Book.class);
        System.out.println(books);
        Set<Integer> idsBook = books
                .stream()
                .map(Book::getIdBook)
                .collect(Collectors.toSet());
        Result<Record4<Integer, String, String, Integer>> fetch = create
                .select(AUTHOR.ID_AUTHOR, AUTHOR.FIRST_NAME, AUTHOR.SECOND_NAME, BOOK.ID_BOOK)
                .from(AUTHOR)
                .join(AUTHOR_BOOK)
                .on(AUTHOR_BOOK.ID_AUTHOR.equal(AUTHOR.ID_AUTHOR))
                .join(BOOK)
                .on(BOOK.ID_BOOK.equal(AUTHOR_BOOK.ID_BOOK))
                .where(BOOK.ID_BOOK.in(idsBook))
                .fetch();
        System.out.println(fetch);
        System.out.println("Book quantity: " + idsBook.size());
        BookModel bookModels[] = new BookModel[idsBook.size()];
        int j = 0;
        for(Integer idBook:idsBook) {
            BookModel bookModel = new BookModel();
            bookModel.setIdBook(idBook);
            List<Author> authors = new ArrayList<>();
            for(int i = 0; i < fetch.size(); i++) {
                if (fetch.get(i).value4().equals(idBook)) {
                    Record4<Integer, String, String, Integer> record = fetch.get(i);
                    Author author = new Author();
                    author.setIdAuthor(record.value1());
                    author.setFirstName(record.value2());
                    author.setSecondName(record.value3());
                    authors.add(author);
                }
            }
            bookModel.setAuthors(authors);
            bookModels[j] = bookModel;
            j++;
        }
        System.out.println(Arrays.toString(bookModels));
    }
}
