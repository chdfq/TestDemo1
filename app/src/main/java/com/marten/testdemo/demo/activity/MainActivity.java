package com.marten.testdemo.demo.activity;

import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.marten.testdemo.R;
import com.marten.testdemo.demo.adapter.ViewPagerAdapter;
import com.marten.testdemo.demo.fragment.FirstFragment;
import com.marten.testdemo.demo.fragment.ForthFragment;
import com.marten.testdemo.demo.fragment.SecondFragment;
import com.marten.testdemo.demo.fragment.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ViewPager mVp;
    private ViewPagerAdapter adapter;
    private List<Fragment> list;
    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private ThirdFragment thirdFragment;
    private ForthFragment forthFragment;
    private RadioGroup mRg;
    private RadioButton mRb1, mRb2, mRb3, mRb4;

    @Override
    public void initView() {
        contentView(R.layout.m_activity_main_page);
        mVp = findViewById(R.id.vp_main);
        mRg = findViewById(R.id.rg1);
        mRb1 = findViewById(R.id.rb1);
        mRb2 = findViewById(R.id.rb2);
        mRb3 = findViewById(R.id.rb3);
        mRb4 = findViewById(R.id.rb4);

        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        thirdFragment = new ThirdFragment();
        forthFragment = new ForthFragment();

        list = new ArrayList<>();
        list.add(firstFragment);
        list.add(secondFragment);
        list.add(thirdFragment);
        list.add(forthFragment);

        FragmentManager manager = getSupportFragmentManager();
        adapter = new ViewPagerAdapter(manager, list);
        mVp.setAdapter(adapter);
        mVp.setCurrentItem(0);
        mRg.check(R.id.rb1);

        mVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        mRg.check(R.id.rb1);
                        break;
                    case 1:
                        mRg.check(R.id.rb2);
                        break;
                    case 2:
                        mRg.check(R.id.rb3);
                        break;
                    case 3:
                        mRg.check(R.id.rb4);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        mVp.setCurrentItem(0);
                        break;
                    case R.id.rb2:
                        mVp.setCurrentItem(1);
                        break;
                    case R.id.rb3:
                        mVp.setCurrentItem(2);
                        break;
                    case R.id.rb4:
                        mVp.setCurrentItem(3);
                        break;
                }
            }
        });
    }
}
