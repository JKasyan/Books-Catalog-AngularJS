package catalog.angularjs.dao;

import catalog.angularjs.Application;
import catalog.angularjs.generated.tables.records.AuthorBookRecord;
import catalog.angularjs.generated.tables.records.AuthorRecord;
import catalog.angularjs.generated.tables.records.BookRecord;
import org.apache.commons.lang.RandomStringUtils;
import org.jooq.DSLContext;
import org.jooq.InsertSetMoreStep;
import org.jooq.InsertSetStep;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Random;

import static catalog.angularjs.generated.Tables.AUTHOR;
import static catalog.angularjs.generated.Tables.AUTHOR_BOOK;
import static catalog.angularjs.generated.Tables.BOOK;

/**
 * Created by evgen on 03.12.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class FillDB {

    @Autowired
    private DSLContext create;

    private static final String NAMES[] = new String[]{"Євген", "Андрій","Роман","Антон",
            "Микола","Даніло","Олексій","Маріна","Вікторія","Віталій","Михайло","Олександр",};

    private static final String SECOND_NAMES[] = new String[]{"Іваненко","Петренко","Сидоренко","Науменко",
            "Василенко", "Васильченко"};

    @Test
    public void fill() {
        Random random = new Random();
        InsertSetStep<AuthorRecord> authorRecordInsertSetStep = create.insertInto(AUTHOR);
        InsertSetMoreStep<AuthorRecord> set = null;
        for(int i = 0; i< 100; i++) {
            set = authorRecordInsertSetStep
                    .set(AUTHOR.FIRST_NAME, NAMES[random.nextInt(NAMES.length - 1)])
                    .set(AUTHOR.SECOND_NAME, SECOND_NAMES[random.nextInt(SECOND_NAMES.length - 1)]);
        }
        set.execute();
        InsertSetStep<BookRecord> bookRecordInsertSetStep = create.insertInto(BOOK);
        InsertSetMoreStep<BookRecord> set1 = null;
        for(int i = 0; i< 100; i++) {
             set1 = bookRecordInsertSetStep
                     .set(BOOK.DATE_PUBLISH, String.valueOf(random.nextInt(2014)))
                     .set(BOOK.TITLE, RandomStringUtils.random(8, true, true))
                     .set(BOOK.SHORT_DESCRIPTION, RandomStringUtils.random(30, true, true));
        }
        set1.execute();
        List<Integer> idsAuthor = create
                .select(AUTHOR.ID_AUTHOR)
                .from(AUTHOR)
                .fetchInto(Integer.class);
        List<Integer> idsBook = create
                .select(BOOK.ID_BOOK)
                .from(BOOK)
                .fetchInto(Integer.class);
        InsertSetStep<AuthorBookRecord> authorBookRecordInsertSetStep = create.insertInto(AUTHOR_BOOK);
        InsertSetMoreStep<AuthorBookRecord> set2 = null;
        for(int i = 0; i< 200; i++) {
            set2 = authorBookRecordInsertSetStep
                    .set(AUTHOR_BOOK.ID_AUTHOR, idsAuthor.get(random.nextInt(idsAuthor.size() - 1)))
                    .set(AUTHOR_BOOK.ID_AUTHOR, idsAuthor.get(random.nextInt(idsAuthor.size() - 1)))
                    .set(AUTHOR_BOOK.ID_BOOK, idsBook.get(random.nextInt(idsBook.size() - 1)));
        }
        set2.execute();
    }
}
