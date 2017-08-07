package com.example.miracles_pc.menudesign.data;

/**
 * Created by hilmansyafei on 8/1/17.
 */

public class TestData {

    private String name;
    private String address;
    private String phoneNumber;

    public void setName(String name){
        this.name = name;
    }

    public String GetName(){
        return name;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String GetPhoneNumber(){
        return phoneNumber;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }
}
