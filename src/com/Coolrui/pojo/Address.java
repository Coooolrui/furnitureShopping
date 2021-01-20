package com.Coolrui.pojo;

/**
 * @Author MaRuiYa
 * @Date 2021/1/5 16:34
 */

import java.util.Date;

/**
 * 收货地址
 */
public class Address {
    private int id;
    private int userId;
    private String userName;
    private String userPhone;
    private Region province;
    private Region city;
    private Region area;
    private Region street;
    private String userAddress;
    private int isDefault;
    private Date createTime;
    private String postcode;

    public Address() {
    }

    public Address(int id, String userName, String userPhone, String userAddress, int isDefault, Region province, Region city, Region area, Region street) {
        this.id = id;
        this.userName = userName;
        this.userPhone = userPhone;
        this.province = province;
        this.city = city;
        this.area = area;
        this.street = street;
        this.userAddress = userAddress;
        this.isDefault = isDefault;
    }



    public Address(int id, int userId, String userName, String userPhone, Region province, Region city, Region area, Region street, String userAddress, int isDefault, Date createTime) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.userPhone = userPhone;
        this.province = province;
        this.city = city;
        this.area = area;
        this.street = street;
        this.userAddress = userAddress;
        this.isDefault = isDefault;
        this.createTime = createTime;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Region getProvince() {
        return province;
    }

    public void setProvince(Region province) {
        this.province = province;
    }

    public Region getCity() {
        return city;
    }

    public void setCity(Region city) {
        this.city = city;
    }

    public Region getArea() {
        return area;
    }

    public void setArea(Region area) {
        this.area = area;
    }

    public Region getStreet() {
        return street;
    }

    public void setStreet(Region street) {
        this.street = street;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", province=" + province +
                ", city=" + city +
                ", area=" + area +
                ", street=" + street +
                ", userAddress='" + userAddress + '\'' +
                ", isDefault=" + isDefault +
                ", createTime=" + createTime +
                ", postcode='" + postcode + '\'' +
                '}';
    }
}
