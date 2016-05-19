package com.zhaofeng.bookkeeping.other;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhaofeng.bookkeeping.R;
import com.zhaofeng.bookkeeping.mainactivity.MainContract;

/**
 * Created by zhaofeng on 16/5/19.
 */
public class OtherFragment extends Fragment
{
    public static final String ARGS="OtherFragment";

    public static OtherFragment newInstance(String title)
    {
        Bundle bundle=new Bundle();
        bundle.putString(OtherFragment.ARGS,title);
        OtherFragment fragment=new OtherFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.other_layout,null);
        return view;
    }
}
