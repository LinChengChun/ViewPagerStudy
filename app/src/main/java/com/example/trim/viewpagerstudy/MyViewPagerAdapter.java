package com.example.trim.viewpagerstudy;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/4.
 * 自定义 ViewPagerAdapter
 */
public class MyViewPagerAdapter extends PagerAdapter {

    private Context mContext = null;//上下文
    private List<View> mList = new ArrayList<View>();////实例化一个List对象，用来存储View对象

    public List<View> getmList() {
        return mList;
    }

    public void setmList(List<View> mList) {
        this.mList = mList;
    }

    public MyViewPagerAdapter(Context mContext, List<View> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    /**
     * 给每个pager来初始化视图
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        MyLog.i("instantiateItem,position = "+position);

        View view = mList.get(position);
        container.addView(view);//加载一个子View到ViewPager
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        MyLog.e("destroyItem...." + position);
        container.removeView(mList.get(position));

        MyLog.i("status: "+ (object == mList.get(position)));
    }

    @Override
    public int getItemPosition(Object object) {
        MyLog.i("getItemPosition..."+super.getItemPosition(object));
        return super.getItemPosition(object);
    }

    @Override
    public int getCount() {
        MyLog.i("getCount..."+ mList.size());
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        MyLog.i("isViewFromObject..."+ (view == object) );
        return view == object;
    }
}
