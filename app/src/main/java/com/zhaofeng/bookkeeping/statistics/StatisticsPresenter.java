package com.zhaofeng.bookkeeping.statistics;

import android.support.annotation.NonNull;

/**
 * Created by zhaofeng on 16/5/23.
 */
public class StatisticsPresenter implements StatisticsContract.Presenter
{
    private final StatisticsContract.View view;

    public StatisticsPresenter(@NonNull StatisticsContract.View view)
    {
        this.view=view;
    }

    @Override
    public void start() {

    }
}
