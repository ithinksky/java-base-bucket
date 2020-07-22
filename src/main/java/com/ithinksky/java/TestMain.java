package com.ithinksky.java;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author tengpeng.gao
 */
public class TestMain {

    public static void main(String[] args) {

        // Exception in thread "main" java.lang.NullPointerException
        List<Pattern> permitallUrlPattern = new ArrayList<>();
        permitallUrlPattern.add(Pattern.compile("ddd"));

        for (Pattern pattern : permitallUrlPattern) {
            if (pattern.matcher(null).find()) {

            }
        }
    }

}
