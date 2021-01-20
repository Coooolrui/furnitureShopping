package com.Coolrui.pojo;

/**
 * @Author MaRuiYa
 * @Date 2021/1/5 16:47
 */

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 商品表
 */
public class Goods {
    private int id;
    private String name;
    private String[] imgs;
    private BigDecimal price;
    //商品简述
    private String gdesc;
    //库存
    private int stock;
    //评价数
    private int appraiseNum;
    //商品详情图片
    private String[] info;
    //创建时间
    private Date createTime;
    //一级分类
    private int classId1;
    //二级分类
    private int classId2;

    private Class aClass;

    public Goods() {
    }

    public Goods(int id, String[] imgs) {
        this.id = id;
        this.imgs = imgs;
    }

    public Goods(int id, String name, String[] imgs, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.imgs = imgs;
        this.price = price;
    }

    public Goods(int id, String name, String[] imgs, BigDecimal price, int stock, Date createTime, Class aClass) {
        this.id = id;
        this.name = name;
        this.imgs = imgs;
        this.price = price;
        this.stock = stock;
        this.createTime = createTime;
        this.aClass = aClass;
    }

    public Goods(int id, String name, String[] imgs, BigDecimal price, String gdesc, int stock, int appraiseNum, String[] info, Date createTime, int classId1, int classId2, Class aClass) {
        this.id = id;
        this.name = name;
        this.imgs = imgs;
        this.price = price;
        this.gdesc = gdesc;
        this.stock = stock;
        this.appraiseNum = appraiseNum;
        this.info = info;
        this.createTime = createTime;
        this.classId1 = classId1;
        this.classId2 = classId2;
        this.aClass = aClass;
    }

    public Goods(int id, String name, String[] imgs, BigDecimal price, Class aClass) {
        this.id = id;
        this.name = name;
        this.imgs = imgs;
        this.price = price;
        this.aClass = aClass;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getGdesc() {
        return gdesc;
    }

    public void setGdesc(String gdesc) {
        this.gdesc = gdesc;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getAppraiseNum() {
        return appraiseNum;
    }

    public void setAppraiseNum(int appraiseNum) {
        this.appraiseNum = appraiseNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getClassId1() {
        return classId1;
    }

    public void setClassId1(int classId1) {
        this.classId1 = classId1;
    }

    public int getClassId2() {
        return classId2;
    }

    public void setClassId2(int classId2) {
        this.classId2 = classId2;
    }

    public String[] getImgs() {
        return imgs;
    }

    public void setImgs(String[] imgs) {
        this.imgs = imgs;
    }

    public String[] getInfo() {
        return info;
    }

    public void setInfo(String[] info) {
        this.info = info;
    }

//    @Override
//    public String toString() {
//        return "Goods{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", imgs=" + Arrays.toString(imgs) +
//                ", price=" + price +
//                ", gdesc='" + gdesc + '\'' +
//                ", stock=" + stock +
//                ", appraiseNum=" + appraiseNum +
//                ", info=" + Arrays.toString(info) +
//                ", createTime=" + createTime +
//                ", classId1=" + classId1 +
//                ", classId2=" + classId2 +
//                ", aClass=" + aClass +
//                '}';
//    }
}
