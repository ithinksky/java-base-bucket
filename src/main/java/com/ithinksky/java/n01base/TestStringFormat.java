package com.ithinksky.java.n01base;

public class TestStringFormat {

    public static void main(String[] args) {

        String str = String.format("Hi,%s %s", "你好", "java");
//    str = "Hi,你好 java";
        System.out.println(str);

        System.out.println(String.format("我是数字：%d %n", 100));
//    str = "我是数字：100"
    }
/**
 *
 * 常用的类型关系:
 * 转换符	详细说明	示例
 * %s	字符串类型	“喜欢请收藏”
 * %c	字符类型	‘m’
 * %b	布尔类型	true
 * %d	整数类型（十进制）	88
 * %x	整数类型（十六进制）	FF
 * %o	整数类型（八进制）	77
 * %f	浮点类型	8.888
 * %a	十六进制浮点类型	FF.35AE
 * %e	指数类型	9.38e+5
 * %g	通用浮点类型（f和e类型中较短的）	不举例(基本用不到)
 * %h	散列码	不举例(基本用不到)
 * %%	百分比类型	％(%特殊字符%%才能显示%)
 * %n	换行符	不举例(基本用不到)
 * %tx	日期与时间类型（x代表不同的日期与时间转换符)	不举例(基本用不到)
 */

}
