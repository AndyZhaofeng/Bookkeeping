package com.zhaofeng.bookkeeping.data.model;

import android.content.Context;
import android.content.res.Resources;

import com.zhaofeng.bookkeeping.R;

import java.io.Serializable;

/**
 * Created by zhaofeng on 16/5/19.
 * 消费类型
 */
public enum ConsumeType implements Serializable
{
    Entertainment,  //娱乐
    Transport,      //交易
    Food,           //食物
    Daily,          //日常
    Advance,        //提升
    Others;         //其它

    /**
     * 传入上下文，输出当前枚举类型对应的文字
     * @param context
     * @return
     */
    public String getString(Context context)
    {
        Resources res=context.getResources();
        switch (this){
            case Entertainment:return res.getString(R.string.entertainment);
            case Transport:return res.getString(R.string.Transport);
            case Food:return res.getString(R.string.Food);
            case Daily:return res.getString(R.string.Daily);
            case Advance:return res.getString(R.string.Advance);
            case Others:return res.getString(R.string.Other);
            default:return res.getString(R.string.Other);
        }
    }
}
