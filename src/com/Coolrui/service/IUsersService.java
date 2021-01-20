package com.Coolrui.service;

import com.Coolrui.pojo.Users;

import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.Date;

/**
 * @Author MaRuiYa
 * @Date 2021/1/5 21:17
 */
public interface IUsersService {
    /**
     * 登录
     * @param usename
     * @param password
     * @return 成功返回用户的id(做cookie) 失败返回-1
     */
    int login(String usename, String password);

    /**
     * 通过id更新用户最后登录的IP和时间 时间在数据库设置
     * @param lastIp 最后登录的ip
     * @param id 用户id
     * @return
     */
    int updateLoginMessage(String lastIp, int id);

    /**
     * 注册时验证邮箱是否唯一
     * @param email
     * @return 不存在：true 存在：false
     */
    boolean verifyEmail(String email);

    /**
     * 修改个人信息时，验证邮箱是否唯一
     * @param email
     * @param id
     * @return
     */
    boolean verifyEmail(String email, int id);

    /**
     * 注册用户
     * @param email
     * @param password
     */
    int registerUser(String email, String password);

    /**
     * 发送验证码，验证邮箱是否可用
     * @param email
     * @return
     */
    void sendAuthCode(String email, String authCode);


    /**
     * 生成6位验证码
     * @return
     */
    String makeAuthCode();

    /**
     * 显示个人信息
     * @param userid
     * @return
     */
    Users doShowProfile(Integer userid);

    /**
     * 更新个人信息
     * @param name
     * @param birthdayDate
     * @param gender
     * @param id
     * @param email
     * @param phone
     * @param nickname
     * @return
     */
    int updateProfile(String name, Date birthdayDate, String gender, int id, String email, String phone, String nickname);

    /**
     * 改变用户的地区
     * @param area
     * @param id
     */
    int AreaChange(String area, int id);

    /**
     * 上传头像
     * @param part 头像
     * @param serverpath 保存的路径
     * @param id 用户id
     * @throws IOException
     */
    void uploadPhoto(Part part, String serverpath, int id) throws IOException;

    /**
     * 修改时个人信息时，验证用户名是否唯一
     * @param nickname
     * @param id
     * @return
     */
    boolean verifyNick(String nickname, int id);

    /**
     * 修改个人信息时，验证电话是否唯一
     * @param phone
     * @param id
     * @return
     */
    boolean verifyPhone(String phone, int id);

    /**
     * 获得用户的头像和用户名
     * @param id
     * @return
     */
    Users getPhotoNickname(int id);

    /**
     * 修改密码
     * @param old
     * @param aNew
     * @param id
     * @return
     */
    int modifyPassword(String old, String aNew, int id);

    /**
     * 通过用户id得到昵称和邮箱
     * @param userid
     * @return
     */
    Users getNickEmail(Integer userid);

    /**
     * 更新用户密码
     * @param email
     * @param password
     * @return
     */
    int updatePassword(String email, String password);
}
