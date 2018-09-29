package com.yj.arouterdemo.bean;

import java.io.Serializable;

public class TestObject implements Serializable{
    private String key;

    public TestObject(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
