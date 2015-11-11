package catalog.angularjs.dao.impl;

import catalog.angularjs.dao.BookRepository;

import catalog.angularjs.generated.tables.pojos.Book;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static catalog.angularjs.generated.Tables.*;

@Repository("bookRepository")
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    private DSLContext create;


    @Override
    public List<Book> selectAll() {
        return create
                .select()
                .from(BOOK)
                .fetchInto(Book.class);
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
