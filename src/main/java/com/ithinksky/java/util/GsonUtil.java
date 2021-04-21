package com.ithinksky.java.util;

import com.google.gson.Gson;

/**
 * @author: tengpeng.gao
 * @since: 2021/4/21 18:40
 */
public class GsonUtil {

    public static void print(Object obj) {
        Gson gson = new Gson();
        System.out.printf(gson.toJson(obj));
    }

}
