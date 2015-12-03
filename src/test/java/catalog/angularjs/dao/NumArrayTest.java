package catalog.angularjs.dao;

import catalog.angularjs.NumArray;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by evgen on 03.12.15.
 */
public class NumArrayTest {

    @Test
    public void test() {
        NumArray numArray = new NumArray(new int[]{0, 1, 2, 3, 4});
        Assert.assertEquals(numArray.sumRange(0, 2), 3);
    }
}
