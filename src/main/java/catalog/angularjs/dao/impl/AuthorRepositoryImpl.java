package catalog.angularjs.dao.impl;

import catalog.angularjs.dao.AuthorRepository;
import catalog.angularjs.generated.tables.pojos.Author;
import catalog.angularjs.generated.tables.pojos.Book;
import catalog.angularjs.generated.tables.records.AuthorRecord;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static catalog.angularjs.generated.Tables.*;

@Repository("authorRepository")
public class AuthorRepositoryImpl implements AuthorRepository {

    @Autowired
    private DSLContext create;

    @Override
    public List<Author> selectAllAuthors() {
        return create
                .select()
                .from(AUTHOR)
                .fetchInto(Author.class);
    }

    @Override
    public void addBook(String idAuthor, Book book) {
        create.select(AUTHOR.ID_AUTHOR).from(AUTHOR).fetchInto(Integer.class);
    }

    @Override
    public void insertAuthor(Author author) {
        create.insertInto(AUTHOR);
        AuthorRecord record = create.newRecord(AUTHOR);
        record.setFirstName(author.getFirstName());
        record.setSecondName(author.getSecondName());
        record.store();
    }
}
