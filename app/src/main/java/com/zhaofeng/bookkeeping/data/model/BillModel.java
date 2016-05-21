package com.zhaofeng.bookkeeping.data.model;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

/**
 * Created by zhaofeng on 16/5/19.
 * 单笔消费详情
 */
public class BillModel extends BmobObject
{
    private String conData;             //消费日期
    private Integer consumeType;    //消费类型----对应ConsumeType枚举类型
    private Integer payTypeModel;  //支付类型-----对应PayTypeModel枚举类型
    private Double consumeAmount;       //支付金额
    private String consumeDetail;       //详细

    public String getConData() {
        return conData;
    }

    public void setConData(String conData) {
        this.conData = conData;
    }

    public Integer getConsumeType() {
        return consumeType;
    }

    public void setConsumeType(Integer consumeType) {
        this.consumeType = consumeType;
    }

    public Integer getPayTypeModel() {
        return payTypeModel;
    }

    public void setPayTypeModel(Integer payTypeModel) {
        this.payTypeModel = payTypeModel;
    }

    public Double getConsumeAmount() {
        return consumeAmount;
    }

    public void setConsumeAmount(Double consumeAmount) {
        this.consumeAmount = consumeAmount;
    }

    public String getConsumeDetail() {
        return consumeDetail;
    }

    public void setConsumeDetail(String consumeDetail) {
        this.consumeDetail = consumeDetail;
    }
}
