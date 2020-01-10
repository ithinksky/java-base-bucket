package com.ithinksky.java.n10lambda.map002;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author tengpeng.gao
 */
public class TestContain {

    public static void main(String[] args) {

        Map<Integer, List<ActionEquityBean>> integerListMap = TestContain.fetchActionEquityMap();

        integerListMap.forEach((k, v) -> {
            System.out.println("k-> " + k + " v ==" + v);
        });

    }

     public static Map<Integer, List<ActionEquityBean>> fetchActionEquityMap() {

        List<ActionEquityBean> equityEntityList = new ArrayList<>();
         equityEntityList.add(new ActionEquityBean(1, "CBC商品活动"));
         equityEntityList.add(new ActionEquityBean(1, "CBC商品上架"));
        equityEntityList.add(new ActionEquityBean(3, "直邮商品上架"));
        equityEntityList.add(new ActionEquityBean(2, "C2C商品上架"));
        equityEntityList.add(new ActionEquityBean(3, "自营商品上架"));
         equityEntityList.add(new ActionEquityBean(5, "无聊职级"));

        Map<Integer, List<ActionEquityBean>> collect =
                equityEntityList.stream()
                        .collect(Collectors.groupingBy(ActionEquityBean::getCreditLevelId));

        Map<Integer, List<ActionEquityBean>> result = new HashMap<>(collect.size());

        collect.forEach((k, v)->{
            result.put(k, TestContain.test(k, v, result));
        });

        return result;
    }

    public static List<ActionEquityBean> test(Integer k,
                                         List<ActionEquityBean> v,
                                         Map<Integer, List<ActionEquityBean>> result) {
        if (k > 1) {
            int nextInt = k - 1;
            List<ActionEquityBean> entityList = result.get(nextInt);
            if (Objects.isNull(entityList)) {
                TestContain.test(nextInt, v, result);
            } else {
                v.addAll(result.get(nextInt));
            }
        }
        return v;
    }


    public static class ActionEquityBean {

        private Integer creditLevelId;

        private String name;

        public ActionEquityBean(Integer creditLevelId, String name) {
            this.creditLevelId = creditLevelId;
            this.name = name;
        }

        @Override
        public String toString() {
            return "ActionEquityBean{" + "creditLevelId=" + creditLevelId + ", name='" + name + '\'' + '}';
        }

        public Integer getCreditLevelId() {
            return creditLevelId;
        }

        public void setCreditLevelId(Integer creditLevelId) {
            this.creditLevelId = creditLevelId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
