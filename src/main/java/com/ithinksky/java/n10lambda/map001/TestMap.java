package com.ithinksky.java.n10lambda.map001;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author tengpeng.gao
 */
public class TestMap {


    public static void main(String[] args) {

        List<RuleBean> ruleBeanList = new ArrayList<RuleBean>();
        ruleBeanList.add(new RuleBean((byte)1, "等级A订单奖励1"));
        ruleBeanList.add(new RuleBean((byte)1, "等级B订单奖励2"));
        ruleBeanList.add(new RuleBean((byte)1, "等级C订单奖励3"));
        ruleBeanList.add(new RuleBean((byte)1, "等级D订单奖励4"));
        ruleBeanList.add(new RuleBean((byte)2, "等级A实名认证奖励5"));
        ruleBeanList.add(new RuleBean((byte)2, "等级B实名认证奖励5"));
        ruleBeanList.add(new RuleBean((byte)2, "等级C实名认证奖励5"));
        ruleBeanList.add(new RuleBean((byte)2, "等级D实名认证奖励5"));

        ruleBeanList.forEach(System.out::println);

        Map<Byte, List<RuleBean>> tet = ruleBeanList.stream().collect(Collectors.groupingBy(RuleBean::getBusinessType));

        tet.forEach((k,v)->{
            System.out.println(k + " : ");
            v.forEach(System.out::println);
        });


    }

}
