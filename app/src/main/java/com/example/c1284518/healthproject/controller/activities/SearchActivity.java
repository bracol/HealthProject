package com.example.c1284518.healthproject.controller.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import com.example.c1284518.healthproject.R;
import com.example.c1284518.healthproject.controller.tabs.SlidingTabLayout;

/**
 * Created by c1284518 on 09/12/2015.
 */
public class SearchActivity extends AppCompatActivity {

    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        bindComponents();
    }

    private void bindComponents() {
        bindPager();
        bindTabs();
    }

    private void bindPager() {
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(new MyPageAdapter(getSupportFragmentManager()));
    }

    private void bindTabs() {
        mSlidingTabLayout = (SlidingTabLayout) findViewById(R.id.tabs);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setCustomTabView(R.layout.custom_tab_view, R.id.tabText);
        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.colorAccent));
        mSlidingTabLayout.setViewPager(mViewPager);
        mSlidingTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

    class MyPageAdapter extends FragmentPagerAdapter {
        String[] tabText = getResources().getStringArray(R.array.tabs);

        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            CentroCustoFragment myFragment = CentroCustoFragment.getInstance(position, SearchActivity.this);

            return myFragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabText[position];
            /*Drawable drawable = getResources().getDrawable(icons[position]);
            drawable.setBounds(0, 0, 100, 100);
            ImageSpan imageSpan = new ImageSpan(drawable);
            SpannableString spannableString = new SpannableString(" ");
            spannableString.setSpan(imageSpan, 0, spannableString.length(), spannableString.SPAN_EXCLUSIVE_EXCLUSIVE);

            return spannableString;*/
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
