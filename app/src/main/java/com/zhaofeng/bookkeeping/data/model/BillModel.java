package com.zhaofeng.bookkeeping.data.model;

import java.io.Serializable;

/**
 * Created by zhaofeng on 16/5/19.
 * 单笔消费详情
 */
public class BillModel implements Serializable
{
    private String conData;             //消费日期
    private ConsumeType consumeType;    //消费类型
    private PayTypeModel payTypeModel;  //支付类型
    private double consumeAmount;       //支付金额
    private String consumeDetail;       //详细

    public String getConData() {
        return conData;
    }

    public void setConData(String conData) {
        this.conData = conData;
    }

    public ConsumeType getConsumeType() {
        return consumeType;
    }

    public void setConsumeType(ConsumeType consumeType) {
        this.consumeType = consumeType;
    }

    public PayTypeModel getPayTypeModel() {
        return payTypeModel;
    }

    public void setPayTypeModel(PayTypeModel payTypeModel) {
        this.payTypeModel = payTypeModel;
    }

    public double getConsumeAmount() {
        return consumeAmount;
    }

    public void setConsumeAmount(double consumeAmount) {
        this.consumeAmount = consumeAmount;
    }

    public String getConsumeDetail() {
        return consumeDetail;
    }

    public void setConsumeDetail(String consumeDetail) {
        this.consumeDetail = consumeDetail;
    }
}
