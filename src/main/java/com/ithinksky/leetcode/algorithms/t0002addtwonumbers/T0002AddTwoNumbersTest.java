package com.ithinksky.leetcode.algorithms.t0002addtwonumbers;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * 类功能描述：2. 两数相加
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *  
 * <p>
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 自己实现的，用了比较蠢的方法，能把自己蠢哭。。。呜呜呜……
 * PS: 没有把握住题中可以利用的规律，达到最终目的。
 *
 *
 * @author: tengpeng.gao
 */
public class T0002AddTwoNumbersTest {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return T0002AddTwoNumbersTest.test(l1, l2);
    }

    public static ListNode buildListNode(String number) {
        String[] strings = number.split(",");
        int length = strings.length;
        ListNode current = new ListNode(Integer.parseInt(strings[0]));
        ListNode header = current;
        for (int i = 1; i < length; i++) {
            ListNode t = new ListNode(Integer.parseInt(strings[i]));
            current.next = t;
            current = t;
        }
        return header;
    }

    public static BigDecimal convertNumber(ListNode listNode) {
        double deep = 0;
        BigDecimal result = BigDecimal.ZERO;
        result = result.add(BigDecimal.valueOf(listNode.val));
        ListNode current;
        while ((current = listNode.next) != null) {
            deep = deep + 1;
            result = result.add(BigDecimal.valueOf(current.val * Math.pow(10.00, deep)));
            listNode = listNode.next;
        }
        return new BigDecimal(result.stripTrailingZeros().toPlainString());
    }

    public static String handlerResult(BigDecimal r) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(r);
        stringBuilder.reverse();

        System.out.println(stringBuilder);

        char[] chars = stringBuilder.toString().toCharArray();
        stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            stringBuilder.append(chars[i]);
            if (i != chars.length - 1) {
                stringBuilder.append(",");
            }
        }
        return stringBuilder.toString();
    }

    public static ListNode test(ListNode l1, ListNode l2) {
        BigDecimal int1 = T0002AddTwoNumbersTest.convertNumber(l1);
        BigDecimal int2 = T0002AddTwoNumbersTest.convertNumber(l2);

        System.out.println(l1);
        System.out.println(l2);

        System.out.println(int1);
        System.out.println(int2);

        // 2.处理
        BigDecimal r = int1.add(int2);
        System.out.println(r);

        // 3.转换出参
        String s = T0002AddTwoNumbersTest.handlerResult(r);
        System.out.println(s);
        ListNode result = T0002AddTwoNumbersTest.buildListNode(s);
        System.out.println(result);
        return result;
    }

    @Test
    public void test1() {
        // 1.解析入参
        ListNode l1 = T0002AddTwoNumbersTest.buildListNode("2,4,3");
        ListNode l2 = T0002AddTwoNumbersTest.buildListNode("5,6,4");

        T0002AddTwoNumbersTest.test(l1, l2);
    }


    @Test
    public void test2() {
        // 1.解析入参
        ListNode l1 = T0002AddTwoNumbersTest.buildListNode("0");
        ListNode l2 = T0002AddTwoNumbersTest.buildListNode("0");

        T0002AddTwoNumbersTest.test(l1, l2);
    }

    @Test
    public void test3() {
        // 1.解析入参
        ListNode l1 = T0002AddTwoNumbersTest.buildListNode("9,9,9,9,9,9,9");
        ListNode l2 = T0002AddTwoNumbersTest.buildListNode("9,9,9,9");

        T0002AddTwoNumbersTest.test(l1, l2);
    }

    @Test
    public void test4() {
        // 1.解析入参
        ListNode l1 = T0002AddTwoNumbersTest.buildListNode("9");
        ListNode l2 = T0002AddTwoNumbersTest.buildListNode("1,9,9,9,9,9,9,9,9,9");

        T0002AddTwoNumbersTest.test(l1, l2);
    }

    @Test
    public void test5() {
        // 1.解析入参
        ListNode l1 = T0002AddTwoNumbersTest.buildListNode("1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1");
        ListNode l2 = T0002AddTwoNumbersTest.buildListNode("5,6,4");

        T0002AddTwoNumbersTest.test(l1, l2);
    }

}
