package com.ithinksky.java.jvm.om;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tengpeng.gao
 */
public class ConstantOOM {

    public static void main(String[] args) {
        try {
            List<String> list = new ArrayList<>();
            int item = 0;
            while (true) {
                list.add(String.valueOf(item++).intern());
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
