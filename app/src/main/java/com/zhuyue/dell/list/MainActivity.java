package com.zhuyue.dell.list;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.zhuyue.dell.list.fragment.Fragment1;
import com.zhuyue.dell.list.fragment.Fragment2;
import com.zhuyue.dell.list.fragment.Fragment3;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    private ViewPager vp;
    private ArrayList<Fragment> list;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = findViewById(R.id.vp);
        rg = findViewById(R.id.rg);
        initData();
        vp.setAdapter(new MyAdapter(getSupportFragmentManager()));
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1l) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i == 0) {
                    rg.check(R.id.rb1);

                } else if (i == 1) {
                    rg.check(R.id.rb2);
                } else {
                    rg.check(R.id.rb3);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb1) {
                    vp.setCurrentItem(0);
                } else if (checkedId ==R.id.rb2) {
                    vp.setCurrentItem(1);

                } else {
                    vp.setCurrentItem(2);

                }
            }
        });
    }

    private void initData() {
        list = new ArrayList<Fragment>();
        list.add(new Fragment1());
        list.add(new Fragment2());
        list.add(new Fragment3());

    }

    class MyAdapter extends FragmentPagerAdapter {


        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return list.get(i);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
