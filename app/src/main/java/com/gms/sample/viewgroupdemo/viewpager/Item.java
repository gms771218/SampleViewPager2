package com.gms.sample.viewgroupdemo.viewpager;

public class Item {
    int key;
    public String name;
    public int resId;
    public boolean enabled = false;

    public Item(String name, int resId) {
        this.key = this.hashCode();
        this.name = name;
        this.resId = resId;
    }

    public Item(int key ,String name, int resId) {
        this.key = key;
        this.name = name;
        this.resId = resId;
    }
}
