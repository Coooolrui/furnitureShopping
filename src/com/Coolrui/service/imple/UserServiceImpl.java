package com.Coolrui.service.imple;

import com.Coolrui.dao.IUsersDao;
import com.Coolrui.dao.imple.UsersDaoImpl;
import com.Coolrui.pojo.Users;
import com.Coolrui.service.IUsersService;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @Author MaRuiYa
 * @Date 2021/1/5 21:19
 */
public class UserServiceImpl implements IUsersService {
    IUsersDao iUsersDao = new UsersDaoImpl();

    @Override
    public int login(String usename, String password) {
        Users users = iUsersDao.queryByUserName(usename);
        if (users.getEmail() != null) {
            if (users.getPassword().equals(password)) {
                return users.getId();
            }
        }
        return -1;
    }

    @Override
    public int updateLoginMessage(String lastIp, int id) {
        return iUsersDao.updateLoginMessage(lastIp, id);
    }

    @Override
    public boolean verifyEmail(String email) {
        Users users = iUsersDao.queryByUserName(email);
        if (users.getEmail() == null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean verifyEmail(String email, int id) {
        Users users = iUsersDao.queryByUserName(email);
        Users users1 = iUsersDao.queryByUserId(id); //自己的
        if (users.getEmail() == null){
            System.out.println(1321321321);
            return true;
        }else {
            System.out.println("输入的："+users.getEmail());
            System.out.println("通过id查的："+users1.getEmail());
            if (users.getEmail().equals(users1.getEmail())){
                return true;
            }else {
                return false;
            }
        }
    }

    @Override
    public int registerUser(String email, String password) {
        return iUsersDao.addUser(email, password);
    }

    @Override
    public void sendAuthCode(String email, String authCode){
        //创建一个HtmlEmail实例对象
        HtmlEmail send = new HtmlEmail();
        try {
            send.setHostName("smtp.qq.com");
            //第一个参数是发送者的QQEamil邮箱   第二个参数是刚刚获取的授权码
            send.setAuthentication("1436022537@qq.com", "thobbmryfvtkgdhe");
            //发送人的邮箱为自己的，用户名可以随便填
            send.setFrom("1436022537@qq.com", "Coolrui家居网");
//			send.setSmtpPort(465); 	//端口号 可以不开
            send.setSSLOnConnect(true); //开启SSL加密
            send.setCharset("utf-8");
            send.addTo(email);//设置收件人  email为你要发送给谁的邮箱账户   上方参数
            send.setSubject("Coolrui家居网"); //邮箱标题
            send.setMsg("欢迎使用Coolrui家居网： " + authCode + "  五分钟内有效！"); //Eamil发送的内容
            send.send();//发送
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String makeAuthCode(){
        String code = "";
        Random rd=new Random();
        for (int i = 0; i < 6; i++) {
            int r = rd.nextInt(10);
            code = code + r;
        }
        return code;
    }

    @Override
    public Users doShowProfile(Integer userid) {
        return iUsersDao.queryByUserId(userid);
    }

    @Override
    public int updateProfile(String name, Date birthdayDate, String gender, int id, String email, String phone, String nickname) {
        return iUsersDao.updateUsers(name, birthdayDate, gender, id, email, phone, nickname);
    }

    @Override
    public int AreaChange(String area, int id) {
        return iUsersDao.updateArea(area, id);
    }

    @Override
    public void uploadPhoto(Part part, String serverpath, int id) throws IOException {
        String disposition = part.getHeader("Content-Disposition");
        String suffix = disposition.substring(disposition.lastIndexOf("."), disposition.length()-1);
        //随机的生存一个32的字符串
        String filename = UUID.randomUUID()+suffix;
        //获取上传的文件名
        InputStream is = part.getInputStream();
        String filepath = serverpath+"/"+filename;
        //动态获取服务器的路径
        FileOutputStream fos = new FileOutputStream(filepath);
        byte[] bty = new byte[1024];
        int length =0;
        while((length=is.read(bty))!=-1){
            fos.write(bty,0,length);
        }
        fos.close();
        is.close();
        //删除原来的图片
        String path = iUsersDao.queryByUserId(id).getUserPhoto();
//        System.out.println(path);
        if (!path.equals("img/tx.png")){
            File file = new File(serverpath.substring(0, serverpath.lastIndexOf("i"))+path);
            //存在则删除
            if (file.exists()){
                file.delete();
            }
        }
        iUsersDao.updatePhoto("img/"+filename, id);
    }

    @Override
    public boolean verifyNick(String nickname, int id) {
        Users users = iUsersDao.queryByUserName(nickname); //通过名字查找的
        Users users1 = iUsersDao.queryByUserId(id); //自己的
        if (users.getNickname() == null){
            return true;
        }else {
            if (users.getNickname().equals(users1.getNickname())){
                return true;
            }else {
                return false;
            }
        }
    }

    @Override
    public boolean verifyPhone(String phone, int id) {
        Users users = iUsersDao.queryByUserName(phone);
        Users users1 = iUsersDao.queryByUserId(id); //自己的
        if (users.getUserphone() == null){
            return true;
        }else {
            if (users.getUserphone().equals(users1.getUserphone())){
                return true;
            }else {
                return false;
            }
        }
    }

    @Override
    public Users getPhotoNickname(int id) {
        return iUsersDao.queryByUserId(id);
    }

    @Override
    public int modifyPassword(String old, String aNew, int id) {
        Users users = iUsersDao.queryByUserId(id);
        if (users.getPassword().equals(old)) {
            return iUsersDao.updatePassword(id, aNew);
        }else {
            return 0;
        }
    }

    @Override
    public Users getNickEmail(Integer userid) {
        Users users = iUsersDao.queryByUserId(userid);
        return users;
    }

    @Override
    public int updatePassword(String email, String password) {
        return iUsersDao.updatePassword(email, password);
    }
}
