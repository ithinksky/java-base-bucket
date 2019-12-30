package com.ithinksky.java.n10lambda.map001;

import java.util.Objects;

/**
 * @author tengpeng.gao
 */
public class RuleBean {

    private Byte businessType;

    private String ruleName;

    public Byte getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Byte businessType) {
        this.businessType = businessType;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public RuleBean(Byte businessType, String ruleName) {
        this.businessType = businessType;
        this.ruleName = ruleName;
    }

    public RuleBean() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RuleBean)) return false;
        RuleBean ruleBean = (RuleBean) o;
        return Objects.equals(getBusinessType(), ruleBean.getBusinessType()) && Objects.equals(getRuleName(), ruleBean.getRuleName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBusinessType(), getRuleName());
    }

    @Override
    public String toString() {
        return "RuleBean{" + "businessType=" + businessType + ", ruleName='" + ruleName + '\'' + '}';
    }
}
