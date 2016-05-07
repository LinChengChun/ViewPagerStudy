package com.example.trim.viewpagerstudy;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivityBackup extends AppCompatActivity {

    private ViewPager mViewPager = null;//定义一个ViewPager控件
    private List<View> mList = new ArrayList<View>();//实例化一个List对象，用来存储要显示的页面
    private LayoutInflater mLayoutInflater = null;//定义一个布局填充器
    private Context mContext = null;//定义一个上下文

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = getApplicationContext();//获取上下文
        mLayoutInflater = getLayoutInflater().from(mContext);//实例化一个布局填充器

        View view1 = mLayoutInflater.inflate(R.layout.layout_one, null);
        View view2 = mLayoutInflater.inflate(R.layout.layout_two, null);
        View view3 = mLayoutInflater.inflate(R.layout.layout_three, null);
        View view4 = mLayoutInflater.inflate(R.layout.layout_one, null);

        mList.add(view1);
        mList.add(view2);
        mList.add(view3);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);//绑定布局文件里面的控件

        MyViewPagerAdapter adapter = new MyViewPagerAdapter(mContext, mList);//实例化一个适配器对象
        mViewPager.setAdapter(adapter);

        mList.add(view4);
        adapter.setmList(mList);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyLog.i("onDestroy()");
    }
}
