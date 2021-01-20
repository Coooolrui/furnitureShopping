package com.Coolrui.pojo;

/**
 * @Author MaRuiYa
 * @Date 2021/1/5 17:14
 */

import java.util.Date;

/**
 * 用户
 */
public class Users {
    private int id;
    private String userphone;
    private String email;
    private String password;
    //昵称
    private String nickname;
    private String userPhoto;
    //最后登录ip
    private String lastip;
    //最后登录时间
    private Date lastTime;
    private Date createTime;

    private String name;
    private Date birthday;
    private int gender;
    private String area;

    public Users() {
    }

    public Users(int id, String userphone, String email, String password, String nickname, String userPhoto, String lastip, Date lastTime, Date createTime, String name, Date birthday, int gender, String area) {
        this.id = id;
        this.userphone = userphone;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.userPhoto = userPhoto;
        this.lastip = lastip;
        this.lastTime = lastTime;
        this.createTime = createTime;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getLastip() {
        return lastip;
    }

    public void setLastip(String lastip) {
        this.lastip = lastip;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
