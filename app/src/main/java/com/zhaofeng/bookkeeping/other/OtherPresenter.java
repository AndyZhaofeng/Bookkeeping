package com.zhaofeng.bookkeeping.other;

import android.support.annotation.NonNull;

/**
 * Created by zhaofeng on 16/5/23.
 */
public class OtherPresenter implements OtherContract.Presenter
{
    private final OtherContract.View view;

    public OtherPresenter(@NonNull OtherContract.View view)
    {
        this.view=view;
    }

    @Override
    public void start() {

    }
}
