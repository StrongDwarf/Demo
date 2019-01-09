package com.xiaobaicai.demo;

import android.net.Uri;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.xiaobaicai.demo.activitys.AppCompatActivityWithNetWork;
import com.xiaobaicai.demo.apiUrls.ApiUrl;
import com.xiaobaicai.demo.datas.AjaxReceiveData;
import com.xiaobaicai.demo.datas.AjaxSendData;
import com.xiaobaicai.demo.datas.LoginForgetPwdSendData;
import com.xiaobaicai.demo.tools.Ajax;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivityWithNetWork {
    private ImageView imageView1;
    private ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.iv_img1);
        imageView2 = findViewById(R.id.iv_img2);
        findViewById(R.id.btn1).setOnClickListener(onClickListener);
        findViewById(R.id.btn2).setOnClickListener(onClickListener);

        bianLi(new AjaxSendData("xiaobaicai"));
        //String str = Ajax.get(new AjaxSendData("18861855098"),ApiUrl.getLoginStatus(),AjaxReceiveData.class);
        //Log.i("xiaobaicai","get请求返回的str:"+str);
        new TestGet().start();
    }

    public class TestGet extends Thread{
        @Override
        public void run(){
            AjaxReceiveData getResult;
            getResult = Ajax.get(new AjaxSendData("18861855098"),ApiUrl.getLoginStatus());
            Log.i("xiaobaicai","get请求返回的str:"+getResult.getCode());
            AjaxReceiveData postResult = Ajax.post(new LoginForgetPwdSendData("18861855098","1234","1234"),ApiUrl.getLoginForgetPwd());
            Log.i("xiaobaicai","post请求返回的code:"+postResult.getData());
        }
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.btn1:
                    Log.i("xiaobaicai","点击了获取图片按钮");
                    //setImage();
                    String url = "http://172.16.41.162:8080/hello/hello.png";
                    setBitImg(url,imageView1,getBaseContext());
                    break;
                case R.id.btn2:
                    /*
                    Log.i("xiaobaicai","点击了获取本地图片按钮");
                    Bitmap bitmap = null;
                    bitmap = SDCardTools.loadBitmapFromSDCard("/storage/emulated/0/Android/data/com.xiaobaicai.demo/cache/hi.png");
                    imageView1.setImageBitmap(bitmap);
                    */
                    Log.i("xiaobaicai","点击了获取图片按钮");
                    //setImage();
                    String url1 = "http://172.16.41.162:8080/hi.png";
                    setBitImg(url1,imageView2,getBaseContext());
                    break;
            }

        }
    };


    private void bianLi(Object obj){
        Field[] fields = obj.getClass().getDeclaredFields();
        for(int i = 0 , len = fields.length; i < len; i++) {
            // 对于每个属性，获取属性名
            String varName = fields[i].getName();
            try {
                // 获取原来的访问控制权限
                boolean accessFlag = fields[i].isAccessible();
                // 修改访问控制权限
                fields[i].setAccessible(true);
                // 获取在对象f中属性fields[i]对应的对象中的变量
                Object o;
                try {
                    o = fields[i].get(obj);

                    if(fields[i].getName().toString() !="$change" && fields[i].getName().toString() != "serialVersionUID"){
                        Log.i("xiaobaicai","获取对象的属性:"+varName+" = "+o);
                    }

                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                // 恢复访问控制权限
                fields[i].setAccessible(accessFlag);
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            }
        }
    }
}