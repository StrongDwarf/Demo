package com.xiaobaicai.demo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int TV1 = 1;
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.lasted_activity);
        linearLayout.removeAllViews();

        LinearLayout linearLayout1 = new LinearLayout(this);
        ImageView imageView = new ImageView(this);
        TextView textView = new TextView(this);


        linearLayout1.setOrientation(LinearLayout.VERTICAL);
        imageView.setBackgroundColor(getResources().getColor(R.color.image_background));
        linearLayout1.addView(imageView,new LinearLayout.LayoutParams(getPixelsFromDp(190),
                getPixelsFromDp(110)));


        textView.setTextColor(getResources().getColor(R.color.text_light));
        textView.setTextSize(14);
        textView.setPadding(getPixelsFromDp(0),getPixelsFromDp(4),getPixelsFromDp(0),getPixelsFromDp(0));
        textView.setText("动态添加的元素");
        linearLayout1.addView(textView,new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout.addView(linearLayout1,new LinearLayout.LayoutParams(getPixelsFromDp(190),ViewGroup.LayoutParams.WRAP_CONTENT));


    }

    private void showpopupWindow(View v) {
        Button btItem1, btItem2, btItem3;

        LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
        View view = layoutInflater.inflate(R.layout.popwindow_layout, null);

        final PopupWindow popupWindow = new PopupWindow(view, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.popupwindow_background));
        popupWindow.setOutsideTouchable(true);
        popupWindow.setAnimationStyle(R.style.MyPopupWindow_anim_style);


        // PopupWindow弹出位置
        popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);

        backgroundAlpha(0.5f);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });
    }

    // 设置屏幕透明度
    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; // 0.0~1.0
        getWindow().setAttributes(lp);
    }

    //输入dp,输出px
    private int getPixelsFromDp(int size){

        DisplayMetrics metrics =new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        return(size * metrics.densityDpi) / DisplayMetrics.DENSITY_DEFAULT;

    }

}