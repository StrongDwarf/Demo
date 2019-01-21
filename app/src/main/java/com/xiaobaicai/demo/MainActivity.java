package com.xiaobaicai.demo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity {
    private LinearLayout llContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llContainer = findViewById(R.id.ll_container);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.ele_product_default,null);

        LinearLayout linearLayout = new LinearLayout(this);
        TextView textView = new TextView(this);
        textView.setText("添加到父元素中的节点1");
        textView.setTextColor(Color.BLUE);
        linearLayout.addView(textView,new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.addView(view);

        llContainer.addView(linearLayout);

        int[] ints = new int[]{2,2,1};
        for(int i =0;i<ints.length;i++){
            LinearLayout linearLayout1 = new LinearLayout(this);
            TextView textView1 = new TextView(this);
            textView1.setText("节点"+i);
            linearLayout1.addView(textView1,new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
            linearLayout1.setOrientation(LinearLayout.VERTICAL);
            for(int j=0;j<ints[i];j++){
                View view1 = inflater.inflate(R.layout.ele_product_default,null);
                linearLayout1.addView(view1);
            }
            llContainer.addView(linearLayout1);
        }

    }
}