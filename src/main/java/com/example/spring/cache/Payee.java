package com.example.spring.cache;

import java.io.Serializable;

public class Payee implements Serializable {

    private String id;
    private String name;


    public static Payee of(String id, String name) {
        Payee payee = new Payee();
        payee.id = id;
        payee.name = name;
        return payee;
    }


    @Override
    public String toString() {
        return "Payee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
