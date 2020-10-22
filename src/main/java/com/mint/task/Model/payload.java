package com.mint.task.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class payload {

    public String scheme;
    public String type;
    public String bank;

    public payload(){    }

    public  String getScheme(){return  scheme;}
    public  void setScheme(String scheme){this.scheme=scheme;}

    @JsonProperty("type")
    public  String getType(){return  type;}
    @JsonProperty("type")
    public  void SetType1(String type){this.type=type;}

    public  String getBank(){return  bank;}
    public  void setBank(String bank){this.bank=bank;}

}

