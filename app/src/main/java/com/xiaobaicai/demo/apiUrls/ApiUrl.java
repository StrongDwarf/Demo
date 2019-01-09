package com.xiaobaicai.demo.apiUrls;

public class ApiUrl{
    //主机地址
    private static String hostUrl = "http://mdev.bmtrip.com";

    //get方法
    //手机号状态查询地址
    private static String loginStatus = hostUrl + "/api/v3/login/status";


    //post方法
    //忘记密码
    private static String loginForgetPwd = hostUrl + "/api/v3/login/forget/pwd";

    public static String getLoginStatus() {
        return loginStatus;
    }

    public static String getLoginForgetPwd() {
        return loginForgetPwd;
    }
}