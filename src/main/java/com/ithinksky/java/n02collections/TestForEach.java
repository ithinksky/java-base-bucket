package com.ithinksky.java.n02collections;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tengpeng.gao
 */
public class TestForEach {

    public static void main(String[] args) {


        Map<String, String> map = new HashMap<>(10);
        map.put("a", "a===");
        map.put("b", "b===");
        map.put("c", "c===");
        map.put("d", "d===");
        map.put("e", "e===");
        map.put("f", "f===");

        map.forEach(
                (k, v) -> {
                    if (k.equalsIgnoreCase("b")) {
                        return;
                    }
                    System.out.println(k + " === " + v);
                });
    }

}
