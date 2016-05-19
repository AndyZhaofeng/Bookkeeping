package com.zhaofeng.bookkeeping.mainactivity;

import android.content.res.Resources;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.zhaofeng.bookkeeping.R;
import com.zhaofeng.bookkeeping.other.OtherFragment;
import com.zhaofeng.bookkeeping.statistics.StatisticsFragment;
import com.zhaofeng.bookkeeping.thismonth.ThisMonthFragment;
import com.zhaofeng.viewpagerindicator.ViewPagerIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View
{
    private MainPresenter mainPresenter;
    private MainContract.View mainContract;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private List<Fragment> mFragments=new ArrayList<>();
    private List<String> mTitles;

    @BindView(R.id.main_indicator)
    ViewPagerIndicator viewPagerIndicator;
    @BindView(R.id.main_viewpager)
    ViewPager viewPager;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.main_navigation)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainContract=this;

        mainPresenter=new MainPresenter(this);
        mainPresenter.start();
        mainPresenter.startDrawerContent(drawerLayout,navigationView);
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {

    }

    @Override
    public void addFragment() {
        Resources res=getResources();
        mTitles= Arrays.asList(res.getString(R.string.fragment_thismonth),
                res.getString(R.string.fragment_statistics),
                res.getString(R.string.fragment_other));
        StatisticsFragment statisticsFragment=StatisticsFragment.newInstance(res.getString(R.string.fragment_statistics));
        ThisMonthFragment thisMonthFragment=ThisMonthFragment.newInstance(res.getString(R.string.fragment_thismonth));
        OtherFragment otherFragment=OtherFragment.newInstance(res.getString(R.string.fragment_other));
        mFragments.add(thisMonthFragment);
        mFragments.add(statisticsFragment);
        mFragments.add(otherFragment);
        fragmentPagerAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        };
        viewPagerIndicator.setVisibleTabs(3);
        viewPagerIndicator.addTabs(mTitles);
        viewPager.setAdapter(fragmentPagerAdapter);
        viewPagerIndicator.setViewPager(viewPager);
        viewPagerIndicator.setViewPagerListener(new ViewPagerIndicator.ViewPagerListener() {
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

    @Override
    public void setupDrawerContent(DrawerLayout drawerLayout,NavigationView navigationView) {
        if(navigationView!=null)
        {
            final ActionBar ab=getSupportActionBar();
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    return false;
                }
            });
        }
    }
}
