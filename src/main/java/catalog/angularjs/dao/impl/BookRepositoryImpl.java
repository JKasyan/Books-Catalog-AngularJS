package catalog.angularjs.dao.impl;

import catalog.angularjs.dao.BookRepository;
import catalog.angularjs.generated.tables.pojos.Author;
import catalog.angularjs.generated.tables.pojos.Book;
import catalog.angularjs.model.BookModel;
import org.jooq.DSLContext;
import org.jooq.Record6;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static catalog.angularjs.generated.Tables.*;

@Repository("bookRepository")
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private DSLContext create;
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(BookRepositoryImpl.class);


    @Override
    public List<BookModel> selectAll() {
        List<Book> books = create
                .select()
                .from(BOOK)
                .fetchInto(Book.class);
        Set<Integer> idsBook = books
                .stream()
                .map(Book::getIdBook)
                .collect(Collectors.toSet());
        Result<Record6<Integer, String, String, Integer, String, String>> fetch = create
                .select(AUTHOR.ID_AUTHOR, AUTHOR.FIRST_NAME, AUTHOR.SECOND_NAME, BOOK.ID_BOOK, BOOK.TITLE, BOOK.SHORT_DESCRIPTION)
                .from(AUTHOR)
                .join(AUTHOR_BOOK)
                .on(AUTHOR_BOOK.ID_AUTHOR.equal(AUTHOR.ID_AUTHOR))
                .join(BOOK)
                .on(BOOK.ID_BOOK.equal(AUTHOR_BOOK.ID_BOOK))
                .where(BOOK.ID_BOOK.in(
                        create
                                .select(BOOK.ID_BOOK)
                                .from(BOOK)
                                .fetchInto(Integer.class)
                ))
                .fetch();
        System.out.println(fetch);
        System.out.println("Book quantity: " + idsBook.size());
        List<BookModel> bookModels = new ArrayList<>(idsBook.size());
        for(Integer idBook:idsBook) {
            BookModel bookModel = new BookModel();
            bookModel.setIdBook(idBook);
            List<Author> authors = new ArrayList<>();
            Consumer<Record6<Integer, String, String, Integer, String, String>> consumer = x -> {
                if (x.value4().equals(idBook)) {
                    Author author = new Author();
                    author.setIdAuthor(x.value1());
                    author.setFirstName(x.value2());
                    author.setSecondName(x.value3());
                    authors.add(author);
                }
            };
            fetch.forEach(consumer);
            bookModel.setAuthors(authors);
            bookModels.add(bookModel);
        }
        return bookModels;
    }

    @Override
    public List<Book> selectBooksByIdAuthor(int idAuthor) {
        return create.select()
                .from(BOOK)
                .join(AUTHOR_BOOK)
                .on(BOOK.ID_BOOK.equal(AUTHOR_BOOK.ID_BOOK))
                .join(AUTHOR)
                .on(AUTHOR.ID_AUTHOR.equal(AUTHOR_BOOK.ID_AUTHOR))
                .where(AUTHOR.ID_AUTHOR.equal(idAuthor))
                .fetchInto(Book.class);
    }
}
