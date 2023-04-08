package org.example;

import com.google.gson.Gson;

public class Data {
    private String name;
    private int id;
    private long number;

    public int getId() {
        return id;
    }

    public long getNumber() {
        return number;
    }

    @Override
    public String toString() {
        Gson gson=new Gson();
        return gson.toJson(this);
    }
}
