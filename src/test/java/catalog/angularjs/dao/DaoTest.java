package catalog.angularjs.dao;

import catalog.angularjs.Application;
import catalog.angularjs.generated.tables.records.TestTableRecord;
import org.apache.commons.lang.RandomStringUtils;
import org.jooq.DSLContext;
import org.jooq.InsertValuesStep1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static catalog.angularjs.generated.Tables.*;
/**
 * Created by evgen on 01.12.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class DaoTest {

    @Autowired
    private DSLContext context;

    private static long SIZE = 30_000;

    private static final Set<String> SET = new HashSet<>();
    static {
        for (long i = 0; i<SIZE; i++){
            SET.add(RandomStringUtils.random(10, true, true));
        }
    }

//    @Test
    public void oneQueryTest() {
        long begin = System.currentTimeMillis();
        InsertValuesStep1<TestTableRecord, String> testValuesStep = context.insertInto(TEST_TABLE, TEST_TABLE.SOME_TEXT);
        InsertValuesStep1<TestTableRecord, String> values = null;
        Iterator<String> iterator = SET.iterator();
        while (iterator.hasNext()){
            values = testValuesStep.values(iterator.next());
        }
        assert values != null;
        values.execute();
        long end = System.currentTimeMillis();
        System.out.println("Time one query: " + (end - begin));
    }

//    @Test
    public void separatedQueriesTest() {
        long begin = System.currentTimeMillis();
        /**/
        Iterator<String> iterator = SET.iterator();
        while (iterator.hasNext()){
            context.insertInto(TEST_TABLE, TEST_TABLE.SOME_TEXT)
                    .values(iterator.next())
                    .execute();
        }
        long end = System.currentTimeMillis();
        System.out.println("Time separated query: " + (end - begin));
    }

    @Test
    public void readTimeTest() {
        long begin = System.currentTimeMillis();
        List<String> list = context.select(TEST_TABLE.SOME_TEXT).from(TEST_TABLE).fetchInto(String.class);
        System.out.println(list.size());
        long end = System.currentTimeMillis();
        System.out.println("Time separated query: " + (end - begin));
    }
}
