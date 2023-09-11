package com.ithinksky.datastructure.search;

import org.junit.Assert;
import org.junit.Test;

/**
 * 类功能描述：
 *
 * @author: tengpeng.gao
 */
public class LinearSearchTest {

    @Test
    public void linearSearch() {

        int[] arr = {1, 2, 4, 65, 7, 9};
        int x = 7;

        int idx = LinearSearch.linearSearch(arr, x);
        Assert.assertEquals(idx, 4);

        x = 100;
        idx = LinearSearch.linearSearch(arr, x);
        Assert.assertEquals(idx, -1);

    }
}