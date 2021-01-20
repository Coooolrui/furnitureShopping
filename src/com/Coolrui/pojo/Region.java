package com.Coolrui.pojo;

/**
 * @Author MaRuiYa
 * @Date 2021/1/5 16:28
 */

/**
 * 地区
 */
public class Region {
    private int id;
    //地区码
    private String code;
    //地区名称
    private String name;
    //地区简称
    private String shortName;
    //上级地区码
    private String superiorCode;
    //精度
    private String lng;
    //维度
    private String lat;
    //排序
    private int sort;
    //地区级别
    private String level;

    public Region() {
    }

    public Region(String code, String name, int id) {
        this.code = code;
        this.name = name;
        this.id = id;
    }

    public Region(int id, String code, String name, String shortName, String superiorCode, String lng, String lat, int sort, String level) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.shortName = shortName;
        this.superiorCode = superiorCode;
        this.lng = lng;
        this.lat = lat;
        this.sort = sort;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getSuperiorCode() {
        return superiorCode;
    }

    public void setSuperiorCode(String superiorCode) {
        this.superiorCode = superiorCode;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
