package com.zhaofeng.bookkeeping.mainactivity;

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

    }
    interface Presenter extends BasePresenter{
    }
}
