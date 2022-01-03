package com.example.sevenstars;

import android.widget.Button;

public class GetterSetter {

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getKey_People() {
        return Key_People;
    }

    public void setKey_People(String key_People) {
        Key_People = key_People;
    }

    public String getMore_Info() {
        return More_Info;
    }

    public void setMore_Info(String more_Info) {
        More_Info = more_Info;
    }


    String Name;
    String Type;
    String Key_People;
    String More_Info;

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    String Address;


    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    int Image;



}
