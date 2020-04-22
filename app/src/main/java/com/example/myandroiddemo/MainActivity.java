package com.example.myandroiddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClick(View view) {
        getPopupWindow();
//        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        popupWindow.showAsDropDown(view);
    }

    /**
     * 创建PopupWindow
     */
    protected void initPopupWindow() {
        //获取自定义布局文件activity_pop_left.xml 布局文件
        final View popipWindow_view = getLayoutInflater().inflate(R.layout.popuwindow_layout, null, false);
        //创建Popupwindow 实例，200，LayoutParams.MATCH_PARENT 分别是宽高
        popupWindow = new PopupWindow(popipWindow_view, 100,
                100, true);
//设置动画效果
//        popupWindow.setAnimationStyle(R.style.AnimationFade);
        //点击其他地方消失
        popipWindow_view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (popipWindow_view != null && popipWindow_view.isShown()) {
                    popupWindow.dismiss();
                    popupWindow = null;
                }
                return false;
            }
        });
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
    }

    /**
     * 获取PopipWinsow实例
     */
    private void getPopupWindow() {
        if (null != popupWindow) {
            popupWindow.dismiss();
            return;
        } else {
            initPopupWindow();
        }
    }

}