package com.zhaofeng.bookkeeping.thismonth;

import android.support.annotation.NonNull;

/**
 * Created by zhaofeng on 16/5/22.
 */
public class ThisMonthPresenter implements ThisMonthContract.Presenter
{
    private final ThisMonthContract.View view;

    public ThisMonthPresenter(@NonNull ThisMonthContract.View view)
    {
        this.view=view;
    }

    @Override
    public void start() {

    }
}
