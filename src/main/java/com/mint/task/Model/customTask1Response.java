package com.mint.task.Model;

import lombok.Data;

@Data
public class customTask1Response {
    public  String success;

    public customTask1Response(){}

    public  String getSuccess(){return  success;}
    public  void setSuccess(String success){this.success=success;}

    public  payload payload;
}

