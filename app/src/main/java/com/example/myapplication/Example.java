package com.example.myapplication;

public class Example {
    private int keyword;
    private String value;
    public Example(int k, String v){
        this.keyword=k;
        this.value = v;
    }

    public int getKeyword() {
        return keyword;
    }

    public void setKeyword(int keyword) {
        this.keyword = keyword;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
