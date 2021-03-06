package com.example.c1284518.healthproject.controller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.c1284518.healthproject.R;
import com.example.c1284518.healthproject.controller.activities.CentroCustoFragment;
import com.example.c1284518.healthproject.controller.activities.ClasseValorFragment;
import com.example.c1284518.healthproject.controller.activities.ItemVendaFragment;
import com.example.c1284518.healthproject.controller.tabs.SlidingTabLayout;

/**
 * Created by c1284518 on 09/12/2015.
 */
public class SearchActivityW extends AppCompatActivity {

    private SlidingTabLayout mSlidingTabLayout;
    public static ViewPager mViewPager;
    public static long id_centro;
    public static long id_item;
    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search2);

        bindComponents();
    }

    private void bindComponents() {
        bindPager();
        bindTabs();
        bindToolbar();

    }

    private void bindToolbar() {
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
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

    }

    class MyPageAdapter extends FragmentStatePagerAdapter {
        String[] tabText = getResources().getStringArray(R.array.tabs);

        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment myFragment;
            if (position == 0) {
                myFragment = CentroCustoFragment.getInstance(position, SearchActivityW.this);
            } else if (position == 1){
                myFragment = ItemVendaFragment.getInstance(position, SearchActivityW.this);
            } else {
                myFragment = ClasseValorFragment.getInstance(position, SearchActivityW.this);
            }
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
