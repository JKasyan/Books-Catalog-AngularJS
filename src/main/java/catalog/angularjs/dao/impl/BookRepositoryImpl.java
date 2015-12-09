package catalog.angularjs.dao.impl;

import catalog.angularjs.dao.BookRepository;
import catalog.angularjs.generated.tables.pojos.Book;
import catalog.angularjs.model.BookModel;
import org.jooq.DSLContext;
import org.jooq.util.postgres.PostgresDSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static catalog.angularjs.generated.Tables.*;
import static org.jooq.impl.DSL.concat;
import static org.jooq.impl.DSL.val;

@Repository("bookRepository")
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private DSLContext create;
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(BookRepositoryImpl.class);



    @Override
    public List<Book> selectBooksByIdAuthor(int idAuthor) {
        return create.select()
                .from(BOOK)
                .join(AUTHOR_BOOK)
                .on(BOOK.ID_BOOK.equal(AUTHOR_BOOK.ID_BOOK))
                .join(AUTHOR)
                .on(AUTHOR.ID_AUTHOR.equal(AUTHOR_BOOK.ID_AUTHOR))
                .where(AUTHOR.ID_AUTHOR.equal(idAuthor))
                .and(BOOK.STATUS.equal(true))
                .fetchInto(Book.class);
    }

    @Override
    public List<BookModel> selectAll() {
        List<BookModel> books = create
                .select(BOOK.ID_BOOK, BOOK.TITLE, BOOK.SHORT_DESCRIPTION,
                        BOOK.DATE_PUBLISH,
                        PostgresDSL.arrayAgg(concat(AUTHOR.FIRST_NAME, val(" "), AUTHOR.SECOND_NAME)).as("authors"))
                .from(AUTHOR)
                .join(AUTHOR_BOOK)
                .on(AUTHOR_BOOK.ID_AUTHOR.equal(AUTHOR.ID_AUTHOR))
                .join(BOOK)
                .on(BOOK.ID_BOOK.equal(AUTHOR_BOOK.ID_BOOK))
                .where(BOOK.STATUS.equal(true))
                .groupBy(BOOK.ID_BOOK)
                .fetchInto(BookModel.class);
        logger.debug("Books: " + books);
        return books;
    }

    @Override
    public void deleteBook(int idBook) {
        create
                .update(BOOK)
                .set(BOOK.STATUS, false)
                .where(BOOK.ID_BOOK.equal(idBook))
                .execute();
    }
}
