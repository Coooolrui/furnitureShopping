package com.Coolrui.pojo;

/**
 * @Author MaRuiYa
 * @Date 2021/1/5 17:00
 */

import java.math.BigDecimal;

/**
 * 订单商品表
 */
public class OrderGoods {
    private int id;
    private int orderId;
    private int goodsId;
    private int goodsNum;
    private BigDecimal goodsPrice;
    private String goodsName;
    private String goodsImg;

    public OrderGoods() {
    }

    public OrderGoods(int goodsId, int goodsNum, BigDecimal goodsPrice, String goodsName, String goodsImg) {
        this.goodsId = goodsId;
        this.goodsNum = goodsNum;
        this.goodsPrice = goodsPrice;
        this.goodsName = goodsName;
        this.goodsImg = goodsImg;
    }

    public OrderGoods(int orderId, int goodsId, int goodsNum, BigDecimal goodsPrice, String goodsName, String goodsImg) {
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.goodsNum = goodsNum;
        this.goodsPrice = goodsPrice;
        this.goodsName = goodsName;
        this.goodsImg = goodsImg;
    }

    public OrderGoods(int goodsNum, BigDecimal goodsPrice, String goodsName, String goodsImg) {
        this.goodsNum = goodsNum;
        this.goodsPrice = goodsPrice;
        this.goodsName = goodsName;
        this.goodsImg = goodsImg;
    }

    public OrderGoods(int id, int orderId, int goodsId, int goodsNum, BigDecimal goodsPrice, String goodsName, String goodsImg) {
        this.id = id;
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.goodsNum = goodsNum;
        this.goodsPrice = goodsPrice;
        this.goodsName = goodsName;
        this.goodsImg = goodsImg;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }


    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }
}
