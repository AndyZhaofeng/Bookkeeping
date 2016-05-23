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
import android.widget.Toast;

import com.zhaofeng.bookkeeping.R;
import com.zhaofeng.bookkeeping.data.model.BillModel;
import com.zhaofeng.bookkeeping.data.model.ConsumeType;
import com.zhaofeng.bookkeeping.data.model.PayTypeModel;
import com.zhaofeng.bookkeeping.other.OtherFragment;
import com.zhaofeng.bookkeeping.statistics.StatisticsFragment;
import com.zhaofeng.bookkeeping.thismonth.ThisMonthFragment;
import com.zhaofeng.viewpagerindicator.ViewPagerIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.listener.SaveListener;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements MainContract.View
{
    private MainPresenter mainPresenter;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private ArrayList<Fragment> mFragments=new ArrayList<>();

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

        Bmob.initialize(this,"d68caa5de12d378e0b7f680db0008a41");
        mainPresenter=new MainPresenter(this);
        mainPresenter.start();
        mainPresenter.startDrawerContent(drawerLayout,navigationView);
    }

    @Override
    public void addFragment() {
        Resources res=getResources();
        String thisMonthStr=res.getString(R.string.fragment_thismonth);
        String statisticStr=res.getString(R.string.fragment_statistics);
        String otherStr=res.getString(R.string.fragment_other);
        viewPagerIndicator.setVisibleTabs(3);
        Observable.from(Arrays.asList(thisMonthStr,statisticStr,otherStr))
                .subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {
                        viewPager.setAdapter(fragmentPagerAdapter);
                        viewPagerIndicator.setViewPager(viewPager);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        viewPagerIndicator.addTab(s);
                    }
                });
        ThisMonthFragment thisMonthFragment=ThisMonthFragment.newInstance(thisMonthStr);
        StatisticsFragment statisticsFragment=StatisticsFragment.newInstance(statisticStr);
        OtherFragment otherFragment=OtherFragment.newInstance(otherStr);
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
            try{
                final ActionBar ab=getSupportActionBar();
                ab.setHomeAsUpIndicator(R.drawable.ic_menu);
                ab.setDisplayHomeAsUpEnabled(true);
                navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                        return false;
                    }
                });
            }catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }
}
