package com.zhaofeng.bookkeeping.mainactivity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

/**
 * Created by zhaofeng on 16/5/19.
 */
public class MainPresenter implements MainContract.Presenter
{
    private final MainContract.View view;

    public MainPresenter(@NonNull MainContract.View view)
    {
        this.view=view;
    }
    @Override
    public void start() {
        view.addFragment();
    }

    @Override
    public void startDrawerContent(DrawerLayout drawerLayout,NavigationView navigationView) {
        view.setupDrawerContent(drawerLayout,navigationView);
    }
}
