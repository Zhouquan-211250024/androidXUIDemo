package com.xuexiang.wheretoeat.adapter.entity;

public class Canteen {

    public String name;
    public int imgPath;
    public String location;
    public String description;
    public String num;

    public Canteen(String name, int img, String location, String description, String num){

        this.name = name;
        this.location = location;
        this.imgPath = img;
        this.description = description;
        this.num = num;
    }

    public String getShopName(){
        return this.name;
    }

    public int getImgPath(){
        return this.imgPath;
    }

    public String getDescription(){
        return this.description;
    }

}
