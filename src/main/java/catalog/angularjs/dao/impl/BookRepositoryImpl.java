package catalog.angularjs.dao.impl;

import catalog.angularjs.dao.BookRepository;
import catalog.angularjs.generated.tables.pojos.Book;
import catalog.angularjs.generated.tables.records.AuthorBookRecord;
import catalog.angularjs.model.BookModel;
import org.jooq.DSLContext;
import org.jooq.InsertValuesStep2;
import org.jooq.UpdateSetFirstStep;
import org.jooq.UpdateSetMoreStep;
import org.jooq.util.postgres.PostgresDSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.function.Predicate;

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

    @Override
    public BookModel selectBook(int id) {
        return create
                .select(BOOK.ID_BOOK, BOOK.TITLE, BOOK.SHORT_DESCRIPTION,
                        BOOK.DATE_PUBLISH,
                        PostgresDSL.arrayAgg(concat(AUTHOR.ID_AUTHOR, val(","),
                                AUTHOR.FIRST_NAME, val(","), AUTHOR.SECOND_NAME)).as("authors"))
                .from(AUTHOR)
                .join(AUTHOR_BOOK)
                .on(AUTHOR_BOOK.ID_AUTHOR.equal(AUTHOR.ID_AUTHOR))
                .join(BOOK)
                .on(BOOK.ID_BOOK.equal(AUTHOR_BOOK.ID_BOOK))
                .where(BOOK.STATUS.equal(true))
                .and(BOOK.ID_BOOK.equal(id))
                .groupBy(BOOK.ID_BOOK)
                .fetchOneInto(BookModel.class);
    }

    @Override
    public void updateBook(BookModel bookModel) {
        create.update(BOOK)
                .set(BOOK.TITLE, bookModel.getTitle())
                .set(BOOK.DATE_PUBLISH, bookModel.getDatePublish())
                .set(BOOK.SHORT_DESCRIPTION, bookModel.getShortDescription())
                .where(BOOK.ID_BOOK.equal(bookModel.getIdBook()))
                .execute();
        List<Integer> existsAuthors = create
                .select(AUTHOR_BOOK.ID_AUTHOR)
                .from(AUTHOR_BOOK)
                .where(AUTHOR_BOOK.ID_BOOK.equal(bookModel.getIdBook()))
                .fetchInto(Integer.class);
        logger.debug("Existing authors: " + existsAuthors);
        List<Integer> newAuthors = new ArrayList<>();
        List<Integer> authors = new ArrayList<>();
        /**
         *
         */
        for(String idAuthor:bookModel.getAuthors()){
            int id = Integer.valueOf(idAuthor);
            authors.add(id);
            if(!existsAuthors.contains(id)) {
                newAuthors.add(id);
            }
        }
        existsAuthors.removeAll(authors);
        logger.debug("New authors: " + newAuthors);
        if(!newAuthors.isEmpty()){
            InsertValuesStep2<AuthorBookRecord, Integer, Integer> insertStep =
                    create.insertInto(AUTHOR_BOOK, AUTHOR_BOOK.ID_AUTHOR, AUTHOR_BOOK.ID_BOOK);
            InsertValuesStep2<AuthorBookRecord, Integer, Integer> valuesStep = null;
            for(Integer idAuthor:newAuthors) {
                valuesStep = insertStep.values(idAuthor, bookModel.getIdBook());
            }
            valuesStep.execute();
        }
        logger.debug("Old authors: " + existsAuthors);
        if(!existsAuthors.isEmpty()) {
            create
                    .delete(AUTHOR_BOOK)
                    .where(AUTHOR_BOOK.ID_AUTHOR.in(existsAuthors))
                    .execute();
        }
    }
}
