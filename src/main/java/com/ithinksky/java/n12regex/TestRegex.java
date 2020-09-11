package com.ithinksky.java.n12regex;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author tengpeng.gao
 */
public class TestRegex {

  /** 分割字符串中的汉字和数字问题 */
  static Pattern p = Pattern.compile("([a-z])*+[\\u4e00-\\u9fa5]+|\\d+");

    public static void main(String[] args) {

        String content = "121212用户名12121212";
//        String content = "lv测试";

        System.out.println("result == " + TestRegex.handlerNumber(content));

    }

    public static String handlerNumber(String content) {

        Matcher m = p.matcher(content);
        List<String> sp = new ArrayList<>();
        while (m.find()) {
            System.out.println(m.group());
            sp.add(m.group());
        }

        StringBuilder sb = new StringBuilder();
        for (String word : sp) {
            sb.append(TestRegex.getContent(word));
        }
        return sb.toString();
    }

    private static String getContent(String word) {
    String pattern = ".*\\d{5,}";
        boolean isMatch = Pattern.matches(pattern, word);
        if (isMatch) {
            word = "**" + word.substring(word.length() - 4);
        }
        return word;
    }

}
