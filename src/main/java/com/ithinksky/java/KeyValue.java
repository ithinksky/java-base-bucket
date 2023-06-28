package com.ithinksky.java;

/**
 * 类功能描述：
 *
 * @author: tengpeng.gao
 */
public class KeyValue {


    private String key;
    private String value;

    public KeyValue() {
    }

    public KeyValue(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "KeyValue{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public static final class KeyValueBuilder {
        private String key;
        private String value;

        private KeyValueBuilder() {
        }

        public static KeyValueBuilder builder() {
            return new KeyValueBuilder();
        }

        public KeyValueBuilder key(String key) {
            this.key = key;
            return this;
        }

        public KeyValueBuilder value(String value) {
            this.value = value;
            return this;
        }

        public KeyValue build() {
            KeyValue keyValue = new KeyValue();
            keyValue.setKey(key);
            keyValue.setValue(value);
            return keyValue;
        }
    }
}
