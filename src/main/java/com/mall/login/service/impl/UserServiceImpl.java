package com.mall.login.service.impl;

import com.mall.exception.ActiveUserException;
import com.mall.exception.RegistException;
import com.mall.login.dao.UserDao;
import com.mall.login.domain.User;
import com.mall.login.service.UserService;
import com.mall.util.MailUtils;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.security.auth.login.LoginException;
import java.sql.SQLException;

/**
 * @author Chichiu
 * @date 2020/7/6 7:18
 */
public class UserServiceImpl implements UserService {

    // 注册功能
    public void regist(User user) throws RegistException {

        // 调用dao中添加用户操作的方法

        try {
            System.out.println("开始添加用户");
            new UserDao().addUser(user);

            // 发送邮件操作
            String emailMsg = "注册成功，请在12小时内<a href='http://localhost:8080/user?method=activeuser&activecode="
                    + user.getActivecode()
                    + "'>激活</a>，激活码是"
                    + user.getActivecode();
            System.out.println(emailMsg);
            MailUtils.sendMail(user.getEmail(), emailMsg);

        } catch (AddressException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
//        catch (SQLException e) {
//            System.out.println("注册失败");
////            throw new RegistException("注册失败");
//        }
//
//        catch (Exception e) {
//            throw new RegistException("邮件发送失败");
//        }
    }

    public void activeUser(String activecode) throws RegistException,
            ActiveUserException {

        // 调用一个dao中的方法，根据activecode查找用户
        UserDao dao = new UserDao();
        User user = null;
        try {
            user = dao.findUserByActiveCode(activecode);
        } catch (SQLException e) {
            throw new RegistException("根据激活码查找用户失败");
        }
        long time = System.currentTimeMillis() - user.getUpdatetime().getTime();

        // 判断它是否超时 2分钟
        if (time > 2 * 60 * 60 * 1000) {
            throw new ActiveUserException("激活码过期");
        }

        // 进行激活操作
        try {
            dao.activeUserByActivecode(activecode);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ActiveUserException("激活失败");
        }

    }

    public User login(String username, String password) throws LoginException {
        UserDao dao = new UserDao();
        User user = null;
        try {
            user = dao.findUserByUserNameAndPassword(username, password);

            if (user == null) {
                throw new LoginException("用户名或密码不正确");
            }
            // 判断用户的状态。
            if (user.getState() == 0) {
                // 用户状态未激活，不能进行登录操作
                throw new LoginException("用户未激活");
            }

        } catch (SQLException e) {
            throw new LoginException("登录失败");
        }

        return user;
    }


}
