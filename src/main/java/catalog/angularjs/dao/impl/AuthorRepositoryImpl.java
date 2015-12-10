package catalog.angularjs.dao.impl;

import catalog.angularjs.dao.AuthorRepository;
import catalog.angularjs.generated.tables.pojos.Author;
import catalog.angularjs.generated.tables.pojos.Book;
import catalog.angularjs.generated.tables.records.AuthorBookRecord;
import catalog.angularjs.generated.tables.records.AuthorRecord;

import catalog.angularjs.generated.tables.records.BookRecord;
import catalog.angularjs.model.BookModel;
import org.apache.log4j.Logger;
import org.jooq.DSLContext;
import org.jooq.InsertSetStep;
import org.jooq.InsertValuesStepN;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static catalog.angularjs.generated.Tables.*;

@Repository("authorRepository")
public class AuthorRepositoryImpl implements AuthorRepository {

    @Autowired
    private DSLContext create;
    private static final Logger logger = Logger.getLogger(AuthorRepositoryImpl.class);

    @Override
    public List<Author> selectAllAuthors() {
        return create
                .select()
                .from(AUTHOR)
                .where(AUTHOR.STATUS.equal(true))
                .limit(100)
                .fetchInto(Author.class);
    }

    @Override
    public void addBook(BookModel bookModel) {
        BookRecord bookRecord = create
                .insertInto(BOOK, BOOK.TITLE, BOOK.DATE_PUBLISH, BOOK.SHORT_DESCRIPTION)
                .values(bookModel.getTitle(), bookModel.getDatePublish(), bookModel.getShortDescription())
                .returning(BOOK.ID_BOOK)
                .fetchOne();
        Integer idBook = bookRecord.getIdBook();
        logger.debug("Added book with id: " + idBook);
        InsertSetStep<AuthorBookRecord> authorBookRecordInsertSetStep = create
                .insertInto(AUTHOR_BOOK);
        InsertValuesStepN<AuthorBookRecord> value = null;
        for(String idAuthor:bookModel.getAuthors()) {
            value = authorBookRecordInsertSetStep.values(idAuthor, idBook);
        }
        assert value != null;
        value.execute();
    }

    @Override
    public void insertAuthor(Author author) {
        AuthorRecord record = create.newRecord(AUTHOR);
        record.setFirstName(author.getFirstName());
        record.setSecondName(author.getSecondName());
        record.store();
    }

    @Override
    public void updateAuthor(Author author) {

    }

    @Override
    public void delete(int idAuthor) {
        /**
         * SELECT ab.id_book, COUNT(*)
         * FROM author_book ab
         * WHERE ab.id_author = (?)
         * GROUP BY ab.id_book
         * HAVING COUNT(*) = 1;
         */
        List<Integer> booksOnlyOfAuthor = create
                .select(AUTHOR_BOOK.ID_BOOK)
                .from(AUTHOR_BOOK)
                .where(AUTHOR_BOOK.ID_AUTHOR.equal(idAuthor))
                .groupBy(AUTHOR_BOOK.ID_BOOK)
                .having(DSL.count().equal(1))
                .fetchInto(Integer.class);
        logger.debug("Book only of author: " + booksOnlyOfAuthor);
        create
                .delete(AUTHOR_BOOK)
                .where(AUTHOR_BOOK.ID_BOOK.in(booksOnlyOfAuthor))
                .and(AUTHOR_BOOK.ID_AUTHOR.equal(idAuthor))
                .execute();
        create
                .update(BOOK)
                .set(BOOK.STATUS, false)
                .where(BOOK.ID_BOOK.in(booksOnlyOfAuthor))
                .execute();
        create
                .update(AUTHOR)
                .set(AUTHOR.STATUS, false)
                .where(AUTHOR.ID_AUTHOR.equal(idAuthor))
                .execute();
    }
}
