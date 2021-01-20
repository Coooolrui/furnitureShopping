package com.Coolrui.pojo;

/**
 * @Author MaRuiYa
 * @Date 2021/1/5 16:44
 */

import java.util.List;

/**
 * 分类表
 */
public class Class {
    private int id;
    //父分类id
    private int parentId;
    private String className;
    //父类的名字
    private String parentName;

    public Class() {
    }

    public Class(String className) {
        this.className = className;
    }

    public Class(int id, String className) {
        this.id = id;
        this.className = className;
    }

    public Class(int id, int parentId, String className, String parentName) {
        this.id = id;
        this.parentId = parentId;
        this.className = className;
        this.parentName = parentName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", className='" + className + '\'' +
                ", parentName='" + parentName + '\'' +
                '}';
    }
}
