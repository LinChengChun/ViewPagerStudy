package com.example.trim.viewpagerstudy;


import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener{

    private ViewPager mViewPager = null;//定义一个ViewPager控件
    private Context mContext = null;//定义一个上下文
    private Fragment[] mFragments = null;//定义一个存放Fragment的数组

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = getApplicationContext();//获取上下文

        initData();
        initView();
        //initActionBar();
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mFragments = new Fragment[]{new FragmentOne(),new FragmentTwo(),new FragmentThree()};
    }

    /**
     * 初始化视图
     */
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager())); //给ViewPager设置适配器：FragmentPagerAdapter
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                //getActionBar().setSelectedNavigationItem(position);
                MyLog.i("onPageSelected position = "+position);
                Toast.makeText(mContext, "onPageSelected position = "+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    private void initActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS); //设置ActionBar的导航模式
        ActionBar.Tab tab1 = actionBar.newTab()
                .setText("微信")
                .setIcon(R.mipmap.ic_launcher)
                .setTabListener(this)
                .setTag(1);
        actionBar.addTab(tab1);

        ActionBar.Tab tab2 = actionBar.newTab()
                .setText("通讯录")
                .setIcon(R.mipmap.ic_launcher)
                .setTabListener(this)
                .setTag(2);
        actionBar.addTab(tab2);

        ActionBar.Tab tab3 = actionBar.newTab()
                .setText("发现")
                .setIcon(R.mipmap.ic_launcher)
                .setTabListener(this)
                .setTag(3);
        actionBar.addTab(tab3);

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    public class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int postion) {
            return mFragments[postion];
        }
        /**
         * 返回要显示的所有的Fragment的数量
         */
        @Override
        public int getCount() {
            return mFragments.length;
        }
    }
}
