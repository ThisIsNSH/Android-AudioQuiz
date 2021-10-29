package com.jahnvi.recog.model;

public class Category {

    String name;
    String category;
    int res;

    public Category(String name, int res, String category) {
        this.name = name;
        this.category = category;
        this.res = res;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }
}
