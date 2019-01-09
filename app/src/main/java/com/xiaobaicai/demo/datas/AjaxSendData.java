package com.xiaobaicai.demo.datas;

public class AjaxSendData extends AjaxSendAbstract{
    private String phone;
    private String name;

    public AjaxSendData(){};
    public AjaxSendData(String phone){
        this.phone = phone;

    };

    public String toString(){
        return "AjaxSendData:{phone='"+phone+"'}";
    }
}