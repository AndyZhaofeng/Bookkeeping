package com.zhaofeng.bookkeeping.data.model;

import android.content.Context;
import android.content.res.Resources;

import com.zhaofeng.bookkeeping.R;

import java.io.Serializable;

/**
 * Created by zhaofeng on 16/5/19.
 */
public enum PayTypeModel implements Serializable
{
    Crash(0),      //现金
    DebitCard(1),  //借记卡
    AliPay(2),     //支付宝
    WeChatPay(3),  //微信支付
    CreditCard(4), //现金支付
    Other(5);      //其它

    private Integer integer;
    private PayTypeModel(Integer integer)
    {
        this.integer=integer;
    }
    public Integer getInteger()
    {
        return integer;
    }
    public String getString(Context context)
    {
        Resources resources=context.getResources();
        switch (this){
            case Crash:return resources.getString(R.string.Crash);
            case DebitCard:return resources.getString(R.string.DebitCard);
            case AliPay:return resources.getString(R.string.AliPay);
            case WeChatPay:return resources.getString(R.string.WeChatPay);
            case CreditCard:return resources.getString(R.string.CreditCard);
            case Other:return resources.getString(R.string.Other);
            default:return resources.getString(R.string.Other);
        }
    }
}
