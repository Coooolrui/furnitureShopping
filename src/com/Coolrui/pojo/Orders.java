package com.Coolrui.pojo;

/**
 * @Author MaRuiYa
 * @Date 2021/1/5 17:04
 */

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单表
 */
public class Orders {
    private int id;
    private int userId;
    private int status;
    private BigDecimal money;
    //支付方式id
    private int paymentId;
    //配送方式id
    private int transportId;
    //收获地址id
    private int addressId;
    //是否评价id
    private int isAppraise;
    //快递单号
    private String expressNo;
    //创建时间
    private Date createTime;
    //收货人姓名
    private String shouName;

    //订单商品
    private OrderGoods orderGoods;

    public Orders() {
    }

    public Orders(int id, int userId, int status, BigDecimal money, int paymentId, int transportId, int addressId, int isAppraise, String expressNo, Date createTime) {
        this.id = id;
        this.userId = userId;
        this.status = status;
        this.money = money;
        this.paymentId = paymentId;
        this.transportId = transportId;
        this.addressId = addressId;
        this.isAppraise = isAppraise;
        this.expressNo = expressNo;
        this.createTime = createTime;
    }

    public Orders(int id, int status, BigDecimal money, String expressNo, Date createTime, int isAppraise, String shouName, OrderGoods orderGoods) {
        this.id = id;
        this.status = status;
        this.money = money;
        this.expressNo = expressNo;
        this.createTime = createTime;
        this.shouName = shouName;
        this.orderGoods = orderGoods;
        this.isAppraise = isAppraise;
    }

    public Orders(int userId, int status, BigDecimal money, int paymentId, int transportId, int addressId, String expressNo) {
        this.userId = userId;
        this.status = status;
        this.money = money;
        this.paymentId = paymentId;
        this.transportId = transportId;
        this.addressId = addressId;
        this.expressNo = expressNo;
    }

    public String getShouName() {
        return shouName;
    }

    public void setShouName(String shouName) {
        this.shouName = shouName;
    }

    public OrderGoods getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(OrderGoods orderGoods) {
        this.orderGoods = orderGoods;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getTransportId() {
        return transportId;
    }

    public void setTransportId(int transportId) {
        this.transportId = transportId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getIsAppraise() {
        return isAppraise;
    }

    public void setIsAppraise(int isAppraise) {
        this.isAppraise = isAppraise;
    }

    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", userId=" + userId +
                ", status=" + status +
                ", money=" + money +
                ", paymentId=" + paymentId +
                ", transportId=" + transportId +
                ", addressId=" + addressId +
                ", isAppraise=" + isAppraise +
                ", expressNo='" + expressNo + '\'' +
                ", createTime=" + createTime +
                ", shouName='" + shouName + '\'' +
                ", orderGoods=" + orderGoods +
                '}';
    }
}
