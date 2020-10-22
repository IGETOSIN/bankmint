package com.mint.task.Model;

import lombok.Data;

@Data
public class bank{
    public  String name;
    public  String url;
    public  String phone;
    public  String city;

    public  bank(){}

    public  String getName(){return  name;}
    public  void setName(String name){this.name=name;}
    public  String getUrl(){return  url;}
    public  void setUrl(String url){this.url=url;}
    public  String getPhone(){return  phone;}
    public  void setPhone(String phone){this.phone=phone;}
    public  String getCity(){return  phone;}
    public  void setCity(String phone){this.phone=phone;}

}
