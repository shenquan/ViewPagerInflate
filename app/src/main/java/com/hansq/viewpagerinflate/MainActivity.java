package com.hansq.viewpagerinflate;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
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

        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.viewGroup);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        //mCount是订单数量，是从订单处得到的数据，我们默认设为3

        mLayouts = new ArrayList<>();
        mDots = new ArrayList<>();
        mCount = 3;
        for (int i = 0; i < mCount; i++) {
            //下面两句必须放在for里面
            View layoutView = layoutInflater.inflate(R.layout.one, null);
            View dotView = layoutInflater.inflate(R.layout.dot, null);

            TextView textView = (TextView)layoutView.findViewById(R.id.tv);
            textView.setText("我是TextView"+(i+1));
            Button button =(Button)layoutView.findViewById(R.id.btn);
            button.setText("我是Button"+(i+1));
            if (i == 0) {
                dotView.setBackgroundResource(R.drawable.dot_select);
            } else {
                dotView.setBackgroundResource(R.drawable.dot_no_select);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                            ViewGroup.LayoutParams.WRAP_CONTENT));
            layoutParams.setMargins(20, 0, 20, 0);
            viewGroup.addView(dotView, layoutParams);

            mLayouts.add(layoutView);
            mDots.add(dotView);

        }

        mViewPager.setAdapter(new MyViewPagerAdapter(mLayouts));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < mCount; i++) {
                    if (i == position) {
                        mDots.get(i).setBackgroundResource(R.drawable.dot_select);
                    } else {
                        mDots.get(i).setBackgroundResource(R.drawable.dot_no_select);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
