package com.ithinksky.java;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 类功能描述：
 *
 * @author: tengpeng.gao
 */
public class TestFilterMonitorUtil {


    private final static List<KeyValue> METRIC_SENSITIVE_WORD_LIST = Lists.newArrayList(

            KeyValue.KeyValueBuilder.builder().key(" ").value("-").build(),
            KeyValue.KeyValueBuilder.builder().key(",").value("-").build(),
            KeyValue.KeyValueBuilder.builder().key("=").value("-").build(),
            KeyValue.KeyValueBuilder.builder().key("\"").value("-").build(),
            KeyValue.KeyValueBuilder.builder().key("\r").value("-").build(),
            KeyValue.KeyValueBuilder.builder().key("\n").value("-").build()
    );

    private final static Set<String> kSet = METRIC_SENSITIVE_WORD_LIST.stream().map(KeyValue::getKey).collect(Collectors.toSet());
    private final static Map<String, String> KvMap = METRIC_SENSITIVE_WORD_LIST.stream().collect(Collectors.toMap(KeyValue::getKey, KeyValue::getValue));

    @Test
    public void test() {

        String msg = " 我就是 传说中的圣人=\"神明\", \r 不知道你能否理解的了！ \r \r";
        for (KeyValue e : METRIC_SENSITIVE_WORD_LIST) {
            if (msg.contains(e.getKey())) {
                msg = msg.replace(e.getKey(), e.getValue());
            }
        }
        System.out.println(JSONObject.toJSONString(msg));

        // =================================================

        String str = " 我就是 传说中的圣人=\"神明\", \r 不知道你能否理解的了！ \n \n";
        StringBuilder sb = new StringBuilder(str);

        int length = sb.length();
        for (int i = 0; i < length; i++) {
            char c = sb.charAt(i);
            String cStr = String.valueOf(c);
            if (kSet.contains(cStr)) {
                sb.setCharAt(i, KvMap.get(cStr).charAt(0));
            }
        }
        String replaced = sb.toString();
        System.out.println(JSONObject.toJSONString(replaced));

        // 在 Java 中，可以使用 String 类的 replace() 方法来替换字符串中的指定字符。
        // 但是该方法只能替换一个字符，无法一次替换多个字符。
        // 为了高效替换字符串中的多个字符，可以使用正则表达式或者 StringBuilder 类。
        // 这两种方法都可以高效地替换字符串中的多个字符，选择哪种方法取决于具体的需求和场景。
        // 正则表达式适用于替换简单的字符模式，而使用 StringBuilder 可以进行更复杂的替换操作。

    }


}
