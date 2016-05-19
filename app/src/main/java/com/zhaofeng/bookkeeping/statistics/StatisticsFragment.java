package com.zhaofeng.bookkeeping.statistics;

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
public class StatisticsFragment extends Fragment
{
    public static final String ARGS="StatisticsFragment";

    public static StatisticsFragment newInstance(String title)
    {
        Bundle bundle=new Bundle();
        bundle.putString(StatisticsFragment.ARGS,title);
        StatisticsFragment fragment=new StatisticsFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.statistics_layout,null);
        return view;
    }
}
