package com.zhaofeng.bookkeeping.thismonth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhaofeng.bookkeeping.R;

/**
 * Created by zhaofeng on 16/5/19.
 */
public class ThisMonthFragment extends Fragment implements ThisMonthContract.View
{
    public static final String ARGS="ThisMonthFragment";

    public static ThisMonthFragment newInstance(String title)
    {
        Bundle bundle=new Bundle();
        bundle.putString(ThisMonthFragment.ARGS,title);
        ThisMonthFragment fragment=new ThisMonthFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.thismonth_layout,null);
        return view;
    }
}
