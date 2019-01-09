package com.xiaobaicai.demo.datas;

public class AjaxReceiveData{
    private Number code;
    private String message;
    private Object data;

    public AjaxReceiveData(){};
    public AjaxReceiveData(Number code,String message,String data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Number getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(Number code) {
        this.code = code;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}