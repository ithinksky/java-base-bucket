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
  static Pattern p = Pattern.compile("([0-9]{0,4}+([a-zA-Z])*+[\\u4e00-\\u9fa5]+([a-z])*+)|\\d{5,}");

    public static void main(String[] args) {
        System.out.println("l123v测试l == " + TestRegex.handlerNumber("l123v测试l"));
        System.out.println("121212用户名12121212 == " + TestRegex.handlerNumber("121212用户名12121212"));
        System.out.println("121212用户名212 == " + TestRegex.handlerNumber("121212用户名212"));
        System.out.println("212用户名212312 == " + TestRegex.handlerNumber("212用户名212312"));
        System.out.println("lv测试l == " + TestRegex.handlerNumber("lv26842测试l"));
        System.out.println("lv测试l == " + TestRegex.handlerNumber("lv测12365试l"));
        System.out.println("lW1562fe2v测试l == " + TestRegex.handlerNumber("lW1562fe2v测试l"));
        System.out.println("lW1562fe2v测123658试l == " + TestRegex.handlerNumber("lW1562fe2v测123658试l"));
        System.out.println("lw170 == " + TestRegex.handlerNumber("lw170"));
        System.out.println("170lw == " + TestRegex.handlerNumber("170lw"));
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
