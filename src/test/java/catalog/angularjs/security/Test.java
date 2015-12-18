package catalog.angularjs.security;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Evgen on 08.11.2015.
 */
public class Test {

    @org.junit.Test
    public void test(){
        int a = ((Integer)null).MAX_VALUE;
        System.out.println(a);
    }

    @org.junit.Test
    public void testSort() {
        List<Integer> list = Arrays.asList(1, 5, 3, 7, 22, 4);
        Comparator<Integer> comparator = (x, y) -> x>y?1:-1;
        System.out.println(comparator);
        Collections.sort(list, comparator);
        System.out.println(list);
        list.forEach(System.out::println);
    }
}
