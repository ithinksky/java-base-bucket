package com.ithinksky.java.n01base.baseutil;

import org.junit.Test;

/**
 * 属性默认值
 *
 * @author tengpeng.gao
 */
public class TestInitTypeValue {

    private byte byteValue;

    private short shortValue;

    private int intValue;

    private long longValue;

    private float floatValue;

    private double doubleValue;

    private char charValue;

    private boolean booleanValue;

    private String stringValue;

    private String[] stringsValue;

    @Test
    public void testInitTypeValue() {

        System.out.println( "byte ========== " + byteValue); // 0
        System.out.println( "short ========== " + shortValue); // 0
        System.out.println( "int ========== " + intValue); // 0
        System.out.println( "long ========== " + longValue); // 0
        System.out.println( "float ========== " + floatValue); // 0.0
        System.out.println( "double ========== " + doubleValue); // 0.0
        System.out.println( "char ========== " + charValue); //  
        System.out.println( "boolean ========== " + booleanValue); // false

        // 对象的全部是 null
        System.out.println( "String ========== " + stringValue);
        System.out.println( "String[] ========== " + stringsValue);
    }


}
