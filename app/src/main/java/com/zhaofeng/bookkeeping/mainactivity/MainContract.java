package com.zhaofeng.bookkeeping.mainactivity;

import android.provider.Settings;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import com.zhaofeng.bookkeeping.BasePresenter;
import com.zhaofeng.bookkeeping.BaseView;

/**
 * Created by zhaofeng on 16/5/19.
 *
 * 用于连接view跟presenter
 */
public interface MainContract {
    interface View extends BaseView<Presenter>{
        void addFragment();
        void setupDrawerContent(DrawerLayout drawerLayout,NavigationView navigationView);

    }
    interface Presenter extends BasePresenter{
        void startDrawerContent(DrawerLayout drawerLayout,NavigationView view);
    }
}
