package catalog.angularjs.dao.impl;

import catalog.angularjs.dao.AuthorRepository;
import catalog.angularjs.generated.tables.pojos.Author;
import catalog.angularjs.model.Book;
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
    public List<Author> findAllAuthors() {
        return create
                .select()
                .from(AUTHOR)
                .fetchInto(Author.class);
    }

    @Override
    public void addBook(String idAuthor, Book book) {
    }
}
