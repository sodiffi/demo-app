package com.example.myapplication;

public class ResponseFormat<D> {
    private String message;
    private boolean success;
    private D d;

    public ResponseFormat(String mes, boolean suc, D d) {
        this.message = mes;
        this.success = suc;
        this.d = d;
    }

    public D getData() {
        return d;
    }

    public String getMes() {
        return message;
    }

    public boolean isSuc() {
        return success;
    }
}
