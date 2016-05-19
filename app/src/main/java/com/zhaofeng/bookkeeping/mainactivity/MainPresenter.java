package com.zhaofeng.bookkeeping.mainactivity;

import android.support.annotation.NonNull;

/**
 * Created by zhaofeng on 16/5/19.
 */
public class MainPresenter implements MainContract.Presenter
{
    private final MainContract.View view;

    public MainPresenter(@NonNull MainContract.View view)
    {
        this.view=view;
        view.setPresenter(this);
    }
    @Override
    public void start() {
        view.addFragment();
    }
}
