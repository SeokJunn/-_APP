package com.example.user.appv06.SubTab.Menutab4;

public class ChildData {
    private  int resId;
    private String name;
    private String price;


    public ChildData(int resId, String name, String price) {
        this.resId = resId;
        this.name = name;
        this.price = price;
    }

    public int getResId(){
        return resId;
    }

    public String getName(){
        return name;
    }

    public String getPrice() {
        return price;
    }

}
