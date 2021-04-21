package com.ithinksky.java.n02collections.list;

import com.ithinksky.java.util.GsonUtil;
import org.junit.Test;

import java.util.Vector;

/**
 *
 * 和 ArrayList 数据结构是一样的，
 * 但会对数组的操作增加 synchronized，
 * 由于需要加锁和释放锁，所以性能较 ArrayList 低
 *
 * @author tengpeng.gao
 */
public class TestVector {

    @Test
    public void testArrayListParamCollection() {

        Vector<String> vector = new Vector<>(10);
        vector.add(null);

        GsonUtil.print(vector);

    }

}

