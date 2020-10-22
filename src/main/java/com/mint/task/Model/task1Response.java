package com.mint.task.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class task1Response {

    public  String scheme;
    public  String type;
    public  String brand;
    public  String prepaid;

    public  task1Response(){}

    public  String getScheme(){return  scheme;}
    public  void setScheme(String success){this.scheme=scheme;}

    public  String getType(){return  type;}

    @JsonProperty("Type")
    public  void setType(String type){this.type=type;}

    public  String getBrand(){return  brand;}
    public  void setBrand(String brand){this.brand=brand;}

    public  String getPrepaid(){return  prepaid;}
    public  void setPrepaid(String prepaid){this.prepaid=prepaid;}

    public country country;
    public  bank bank;
    public  number number;
}


   class country {

    public String numeric;
    public String alpha2;
    public   String name;
    public   String emoji;
    public   String currency;
    public   String latitude;
    public   String longitude;

    public country(){    }

    public  String getNumeric(){return  numeric;}
    public  void setNumeric(String numeric){this.numeric=numeric;}

    public  String getAlpha2(){return  alpha2;}
    public  void SetAlpha2(String alpha2){this.alpha2=alpha2;}

    public  String getName(){return  name;}
    public  void setName(String name){this.name=name;}

    public  String getEmoji(){return  emoji;}
    public  void setEmoji(String emoji){this.emoji=emoji;}

    public  String getCurrency(){return  currency;}
    public  void setCurrency(String currency){this.currency=currency;}

    public  String getLatitude(){return  latitude;}
    public  void setLatitude(String latitude){this.latitude=latitude;}

       public  String getLongitude(){return  longitude;}
       public  void setLongitude(String longitude){this.longitude=longitude;}

}

class number{
    public  String length;
    public  String luhn;

    public  number(){}

    public  String getLength(){return  length;}
    public  void setLength(String length){this.length=length;}
    public  String getLuhn(){return  luhn;}
    public  void setLuhn(String luhn){this.luhn=luhn;}


}
