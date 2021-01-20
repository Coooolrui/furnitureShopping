package com.Coolrui.pojo;

/**
 * @Author MaRuiYa
 * @Date 2021/1/5 17:12
 */
//配送方式
public class Transports {
    private int id;
    //配送方式名
    private String name;

    public Transports() {
    }

    public Transports(int id, String name) {
        this.id = id;
        this.name = name;
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
}
