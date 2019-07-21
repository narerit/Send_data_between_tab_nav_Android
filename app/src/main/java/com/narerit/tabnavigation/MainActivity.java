package com.narerit.tabnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private PromotionFragment mPromotionFragment;
    private SavedFragment mSavedFragment;
    private ViewPager mViewPager;
    private MyPagerAdapter mMyPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.viewpager_container);
        initViewPager();
    }

    private void initViewPager() {
        mPromotionFragment = new PromotionFragment();
        mSavedFragment = new SavedFragment();

        mMyPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());

        mMyPagerAdapter.addFragment(mPromotionFragment);
        mMyPagerAdapter.addFragment(mSavedFragment);

        mViewPager.setAdapter(mMyPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tab_top);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.getTabAt(0).setText("Promotions");
        tabLayout.getTabAt(1).setText("Saved");

    }
}
