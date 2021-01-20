package com.Coolrui.dao;

import com.Coolrui.pojo.Users;

import java.sql.Date;

/**
 * @Author MaRuiYa
 * @Date 2021/1/5 20:37
 */
public interface IUsersDao {
    /**
     * 通过用户名查询用户(昵称，电话，邮箱)
     * @param username
     * @return 用户信息
     */
    Users queryByUserName(String username);

    /**
     * 通过id更新用户最后登录的IP和时间 时间在数据库设置
     * @param lastIp
     * @param id
     * @return
     */
    int updateLoginMessage(String lastIp, int id);

    /**
     * 用户信息添加到数据库
     * @param email
     * @param password
     * @return
     */
    int addUser(String email, String password);

    /**
     * 通过id查询用户信息
     * @param userid
     * @return
     */
    Users queryByUserId(Integer userid);

    /**
     * 通过id更新个人基本信息
     * @param name
     * @param birthdayDate
     * @param gender
     * @param id
     * @param email
     * @param phone
     * @param nickname
     * @return
     */
    int updateUsers(String name, Date birthdayDate, String gender, int id, String email, String phone, String nickname);

    /**
     * 更新用户所属地区
     * @param area
     * @param id
     * @return
     */
    int updateArea(String area, int id);

    /**
     * 更新用户头像
     * @param filepath
     * @param id
     */
    int updatePhoto(String filepath, int id);

    /**
     * 更新数据库密码
     * @param id
     * @param password
     * @return
     */
    int updatePassword(int id, String password);

    /**
     * 更新用户密码
     * @param email
     * @param password
     * @return
     */
    int updatePassword(String email, String password);
}
