package com.Coolrui.dao.imple;

import com.Coolrui.common.JDBCTemplate;
import com.Coolrui.common.PreparedStatementSetter;
import com.Coolrui.common.ResultSetGetter;
import com.Coolrui.dao.IUsersDao;
import com.Coolrui.pojo.Users;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author MaRuiYa
 * @Date 2021/1/5 20:41
 */
public class UsersDaoImpl implements IUsersDao {

    @Override
    public Users queryByUserName(String username) {
        String sql = "SELECT * FROM jj_users WHERE nickname = ? or email = ? or userphone = ?";
        Users users = new Users();
        JDBCTemplate.query(sql, new PreparedStatementSetter() {
            @Override
            public void setterValues(PreparedStatement pstat) throws SQLException {
                pstat.setString(1, username);
                pstat.setString(2, username);
                pstat.setString(3, username);
            }
        }, new ResultSetGetter() {
            @Override
            public void getterValues(ResultSet rs) throws SQLException {
                if (rs.next()) {
                    users.setId(rs.getInt(1));
                    users.setUserphone(rs.getString(2));
                    users.setEmail(rs.getString(3));
                    users.setPassword(rs.getString(4));
                    users.setNickname(rs.getString(5));
                    users.setUserPhoto(rs.getString(6));
                    users.setLastip(rs.getString(7));
                    users.setLastTime(rs.getDate(8));
                    users.setCreateTime(rs.getDate(9));
                }
            }
        });
        return users;
    }

    @Override
    public int updateLoginMessage(String lastIp, int id) {
        String sql = "UPDATE jj_users SET lastip = ?, lastTime = NOW() WHERE id = ?;";
        return JDBCTemplate.update(sql, preparedStatement->{
            preparedStatement.setString(1, lastIp);
            preparedStatement.setInt(2, id);
        });
    }

    @Override
    public int addUser(String email, String password) {
        String sql = "insert into jj_users(email, password, createTime) value(?, ?, now())";
        return JDBCTemplate.update(sql, pstat -> {
            pstat.setString(1, email);
            pstat.setString(2, password);
        });
    }

    @Override
    public Users queryByUserId(Integer userid) {
        String sql = "select * from jj_users where id = ?";
        Users users = new Users();
        JDBCTemplate.query(sql, pstat -> {
            pstat.setInt(1, userid);
        }, rs -> {
            if (rs.next()) {
                users.setId(rs.getInt(1));
                users.setUserphone(rs.getString(2));
                users.setEmail(rs.getString(3));
                users.setPassword(rs.getString(4));
                users.setNickname(rs.getString(5));
                users.setUserPhoto(rs.getString(6));
                users.setLastip(rs.getString(7));
                users.setLastTime(rs.getDate(8));
                users.setCreateTime(rs.getDate(9));
                users.setName(rs.getString(10));
                users.setBirthday(rs.getDate(11));
                users.setGender(rs.getInt(12));
                users.setArea(rs.getString(13));
            }
        });
        return users;
    }

    @Override
    public int updateUsers(String name, Date birthdayDate, String gender, int id, String email, String phone, String nickname) {
        String sql = "update jj_users set name = ?, birthday = ?, gender = ?, email = ?, userphone = ?, nickname = ?  where id = ?";
        return JDBCTemplate.update(sql, pstat -> {
            pstat.setString(1, name);
            pstat.setDate(2, birthdayDate);
            pstat.setString(3, gender);
            pstat.setString(4, email);
            pstat.setString(5, phone);
            pstat.setString(6, nickname);
            pstat.setInt(7, id);
        });
    }

    @Override
    public int updateArea(String area, int id) {
        String sql = "update jj_users set area = ? where id = ?";
        return JDBCTemplate.update(sql, pstat -> {
            pstat.setString(1, area);
            pstat.setInt(2, id);
        });
    }

    @Override
    public int updatePhoto(String filepath, int id) {
        String sql = "update jj_users set userPhoto = ? where id = ?";
        return JDBCTemplate.update(sql, pstat -> {
            pstat.setString(1, filepath);
            pstat.setInt(2, id);
        });
    }

    @Override
    public int updatePassword(int id, String password) {
        String sql = "update jj_users set password = ? where id = ?";
        return JDBCTemplate.update(sql, pstat -> {
            pstat.setString(1, password);
            pstat.setInt(2, id);
        });
    }

    @Override
    public int updatePassword(String email, String password) {
        String sql = "UPDATE jj_users SET PASSWORD = ? WHERE email = ?";
        return JDBCTemplate.update(sql, pstat -> {
            pstat.setString(1, password);
            pstat.setString(2, email);
        });
    }

    public static void main(String[] args) {
        new UsersDaoImpl().updatePhoto("img/tx1.png", 1);
    }
}
