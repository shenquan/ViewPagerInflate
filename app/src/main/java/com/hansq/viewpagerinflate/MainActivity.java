package com.hansq.viewpagerinflate;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<View> mLayouts;
    private List<View> mDots;
    private ViewPager mViewPager;
    private int mCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewGroup viewGroup = (ViewGroup)findViewById(R.id.viewGroup);
        mViewPager = (ViewPager)findViewById(R.id.viewPager);
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        //mCount是订单数量，是传过来的数据。在此处我们令其为List的长度
        mCount = mLayouts.size();

        for(int i = 0;i<mCount;i++){
            mLayouts.add(layoutInflater.inflate(R.layout.one,null));
            mDots.add(layoutInflater.inflate(R.layout.dot,null));
            viewGroup.addView(mDots.get(i));
            if(i==0){
                mDots.get(i).setBackgroundResource(R.drawable.dot_select);
            }else{
                mDots.get(i).setBackgroundResource(R.drawable.dot_no_select);
            }
        }

        mViewPager.setAdapter(new MyViewPagerAdapter(mLayouts));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



    }
}
