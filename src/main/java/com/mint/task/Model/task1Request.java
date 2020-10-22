package com.mint.task.Model;

import lombok.Data;

@Data
public class task1Request {
    public  String cardDigitNo;
    public  task1Request(){}

    public  String cardDigitNo(){return  cardDigitNo;}
    public  void setCardDigitNo(String cardDigitNo){this.cardDigitNo=cardDigitNo;}
}
