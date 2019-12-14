package com.ithinksky.java.n01base.baseutil;

import org.junit.Test;

import java.util.Objects;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * @author tengpeng.gao
 */
public class TestObjects {

    @Test
    public void testA() {

        Integer currentDepositoryIdObject = 1;
        Integer targetDepositoryIdObject = 2;

        assertFalse(Objects.equals(currentDepositoryIdObject, targetDepositoryIdObject));
    }

    @Test
    public void testB() {

        Integer currentDepositoryIdObject = 1;
        Integer targetDepositoryIdObject = 1;

        assertTrue(Objects.equals(currentDepositoryIdObject, targetDepositoryIdObject));
    }



    @Test
    public void testC() {

        int currentDepositoryIdObject = 1;
        Integer targetDepositoryIdObject = 1;

        assertTrue(Objects.equals(currentDepositoryIdObject, targetDepositoryIdObject));
    }

    @Test
    public void testD() {

        Integer currentDepositoryIdObject = 1;
        int targetDepositoryIdObject = 1;

        assertTrue(Objects.equals(currentDepositoryIdObject, targetDepositoryIdObject));
    }

}
