package com.example.amrit.recyclerviewwithdatabase;

public class ModelClass {

    private String hello;
    private int number;

    public ModelClass(String hello, int number) {
        this.hello = hello;
        this.number = number;
    }

    public ModelClass() {
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
