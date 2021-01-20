package com.Coolrui.pojo;

/**
 * @Author MaRuiYa
 * @Date 2021/1/5 17:09
 */

/**
 * 支付方式表
 */
public class Payments {
    private int id;
    //支付方式名
    private String name;
    //对应的图片
    private String img;

    public Payments() {
    }

    public Payments(int id, String name, String img) {
        this.id = id;
        this.name = name;
        this.img = img;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
