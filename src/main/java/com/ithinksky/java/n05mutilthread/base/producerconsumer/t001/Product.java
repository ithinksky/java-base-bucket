package com.ithinksky.java.n05mutilthread.base.producerconsumer.t001;

/**
 * 产品
 *
 * @author tengpeng.gao
 * @since 2019-02-27
 */
public class Product {
    @Override
    public String toString() {
        return "Product{" + "name='" + name + '\'' + ", productNo='" + productNo + '\'' + '}';
    }

    private String name;

    public Product(String name, String productNo) {
        this.name = name;
        this.productNo = productNo;
    }

    private String productNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }
}
