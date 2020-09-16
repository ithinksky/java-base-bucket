package com.ithinksky.java.n10lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tengpeng.gao
 */
public class ListSort {

    public static void main(String[] args) {

        //
        List<TabBean> list = new ArrayList<>(3);
        TabBean tabBean = new TabBean();
        tabBean.setKey("1");
        tabBean.setName("A");
        list.add(tabBean);

        tabBean = new TabBean();
        tabBean.setKey("3");
        tabBean.setName("C");
        list.add(tabBean);

        tabBean = new TabBean();
        tabBean.setKey("2");
        tabBean.setName("B");
        list.add(tabBean);


        List<TabBean> collect = list.stream().sorted(Comparator.comparing(TabBean::getKey))
                .collect(Collectors.toList());
        System.out.println("collect ==== " + collect);


    }

    private static class TabBean {
        private String key;
        private String name;

        public TabBean() {
        }

        public TabBean(String key, String name) {
            this.key = key;
            this.name = name;
        }

        @Override
        public String toString() {
            return "TabBean{" +
                    "key='" + key + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
