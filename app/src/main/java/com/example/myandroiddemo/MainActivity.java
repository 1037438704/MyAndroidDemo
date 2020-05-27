package com.example.myandroiddemo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.myandroiddemo.adp.FragmentTabAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<Fragment> fragments;
    private FragmentTabAdapter tabAdapter;
    TextView tvTabOne,tvTabTwo,tvTabThree,tvTabFour,tvTabFive;
    ImageView ivTabOne,ivTabTwo,ivTabThree,ivTabFour,ivTabFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragments = new ArrayList<>();
        fragments.add(BlankFragment.newInstance(1));
        fragments.add(BlankFragment.newInstance(2));
        fragments.add(BlankFragment.newInstance(3));
        fragments.add(BlankFragment.newInstance(4));
        fragments.add(BlankFragment.newInstance(5));
        tabAdapter = new FragmentTabAdapter(this, fragments, R.id.fl_layout);

        tvTabOne = findViewById(R.id.tv_tab_one);
        tvTabTwo = findViewById(R.id.tv_tab_two);
        tvTabThree = findViewById(R.id.tv_tab_three);
        tvTabFour = findViewById(R.id.tv_tab_four);
        tvTabFive = findViewById(R.id.tv_tab_five);


        ivTabOne = findViewById(R.id.iv_tab_one);
        ivTabTwo = findViewById(R.id.iv_tab_two);
        ivTabThree = findViewById(R.id.iv_tab_three);
        ivTabFour = findViewById(R.id.iv_tab_four);
        ivTabFive = findViewById(R.id.iv_tab_five);

        findViewById(R.id.ll_tab_one).setOnClickListener(this);
        findViewById(R.id.ll_tab_two).setOnClickListener(this);
        findViewById(R.id.ll_tab_three).setOnClickListener(this);
        findViewById(R.id.ll_tab_four).setOnClickListener(this);
        findViewById(R.id.ll_tab_five).setOnClickListener(this);

        initListener();
    }
    /**
     *  底部导航栏的点击事件
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_tab_one:
                tabAdapter.setCurrentFragment(0);
                break;
            case R.id.ll_tab_two:
                tabAdapter.setCurrentFragment(1);
                break;
            case R.id.ll_tab_three:
                tabAdapter.setCurrentFragment(2);
                break;
            case R.id.ll_tab_four:
                tabAdapter.setCurrentFragment(3);
                break;
            case R.id.ll_tab_five:
                tabAdapter.setCurrentFragment(4);
                break;
        }
    }


    protected void initListener() {
        tabAdapter.setOnTabChangeListener(new FragmentTabAdapter.OnTabChangeListener() {
            @Override
            public void OnTabChanged(int index) {
                tvTabOne.setTextColor(getResources().getColor(R.color.colorAccent));
                tvTabTwo.setTextColor(getResources().getColor(R.color.colorAccent));
                tvTabThree.setTextColor(getResources().getColor(R.color.colorAccent));
                tvTabFour.setTextColor(getResources().getColor(R.color.colorAccent));
                tvTabFive.setTextColor(getResources().getColor(R.color.colorAccent));

                ivTabOne.setImageResource(R.mipmap.ic_launcher_round);
                ivTabTwo.setImageResource(R.mipmap.ic_launcher_round);
                ivTabThree.setImageResource(R.mipmap.ic_launcher_round);
                ivTabFour.setImageResource(R.mipmap.ic_launcher_round);
                ivTabFive.setImageResource(R.mipmap.ic_launcher_round);

                switch (index){
                    case 0:
                        tvTabOne.setTextColor(getResources().getColor(R.color.colorPrimary));
                        ivTabOne.setImageResource(R.mipmap.ic_launcher1);
                        break;
                    case 1:
                        tvTabTwo.setTextColor(getResources().getColor(R.color.colorPrimary));
                        ivTabTwo.setImageResource(R.mipmap.ic_launcher1);
                        break;
                    case 2:
                        tvTabThree.setTextColor(getResources().getColor(R.color.colorPrimary));
                        ivTabThree.setImageResource(R.mipmap.ic_launcher1);
                        break;
                    case 3:
                        tvTabFour.setTextColor(getResources().getColor(R.color.colorPrimary));
                        ivTabFour.setImageResource(R.mipmap.ic_launcher1);
                        break;
                    case 4:
                        tvTabFive.setTextColor(getResources().getColor(R.color.colorPrimary));
                        ivTabFive.setImageResource(R.mipmap.ic_launcher1);
                        break;
                }

            }
        });
    }
}


//public class MainActivity extends AppCompatActivity {
//    private PopupWindow popupWindow;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//
//    public void OnClick(View view) {
//        getPopupWindow();
////        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
//        popupWindow.showAsDropDown(view);
//    }
//
//    /**
//     * 创建PopupWindow
//     *  1. 为了让PopupWindow自适应屏幕的宽度，设置宽度时用ViewGroup.LayoutParams.FILL_PARENT，为了自适应子布局的高度，
//     *  设置高度时用ViewGroup.LayoutParams.WRAP_CONTENT
//     *
//     *   2. 由于PopupWindow类没有继承ViewGroup类，所以inflater.inflate(int resource, ViewGroup root)方法的第二个参数只能传为null
//     *   ，传null会使最外层布局的android:layout_xxx都不起作用。所以高度是以第二层布局为主
//     *
//     *   3. 为了设置背景和边距，其背景只能设置在第二层布局里，因第一层布局的android:layout_marginXxx不起作用，
//     *   而设置android:padding_Xxx不会影响背景。
//     *
//     *   4. menu有一个特点，就是点外部，menu菜单要消失，要实现这个，有几个属性要一起设置：
//     *   p.setOutsideTouchable(false);p.setBackgroundDrawable();p.setFocusable(true);
//     *
//     */
//    protected void initPopupWindow() {
//        //获取自定义布局文件activity_pop_left.xml 布局文件
//        final View popipWindow_view = getLayoutInflater().inflate(R.layout.popuwindow_layout, null, false);
//        //创建Popupwindow 实例，200，LayoutParams.MATCH_PARENT 分别是宽高
//        popupWindow = new PopupWindow(popipWindow_view, ViewGroup.LayoutParams.WRAP_CONTENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT, true);
////设置动画效果
////        popupWindow.setAnimationStyle(R.style.AnimationFade);
//        //点击其他地方消失
//        popipWindow_view.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (popipWindow_view != null && popipWindow_view.isShown()) {
//                    popupWindow.dismiss();
//                    popupWindow = null;
//                }
//                return false;
//            }
//        });
//        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
//    }
//
//    /**
//     * 获取PopipWinsow实例
//     */
//    private void getPopupWindow() {
//        if (null != popupWindow) {
//            popupWindow.dismiss();
//            return;
//        } else {
//            initPopupWindow();
//        }
//    }
//
//}