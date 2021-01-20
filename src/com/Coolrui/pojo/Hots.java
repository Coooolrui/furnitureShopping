package com.Coolrui.pojo;

/**
 * @Author MaRuiYa
 * @Date 2021/1/5 16:58
 */

/**
 * 精品商品展示
 */
public class Hots {
    private int id;
    private int classId;
    private int goodsId;
    private String img;

    public Hots() {
    }

    public Hots(int id, int classId, int goodsId, String img) {
        this.id = id;
        this.classId = classId;
        this.goodsId = goodsId;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
