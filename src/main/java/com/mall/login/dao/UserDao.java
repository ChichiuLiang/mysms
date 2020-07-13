package com.mall.login.dao;

import com.mall.login.domain.User;
import com.mall.util.DataSourceUtils;
import com.mall.util.Md5Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @author Chichiu
 * @date 2020/7/6 7:23
 */
public class UserDao {

    // 添加用户操作
    public void addUser(User user) throws SQLException {

        // 1.创建QueryRunner
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        System.out.println("创建QueryRunner" + runner);
        // 2.执行sql语句
        //默认用户role=user  state=0 代表未激活
        String sql = "insert into users(username,password,nickname,email,role,state,activecode) " +
                "values(?,?,?,?,'user','0',?)";
        System.out.println("sql:" + sql +
                "\nusername:" + user.getUsername() +
                "\nmd5密码" + Md5Utils.md5(user.getPassword()) +
                "\n昵称" + user.getNickname() +
                "\n邮箱" + user.getEmail() +
                "\n激活码" + user.getActivecode());


        runner.update(
                sql,
                user.getUsername(),
                Md5Utils.md5(user.getPassword()),
                user.getNickname(),
                user.getEmail(),
                user.getActivecode()

        );
    }

    public User findUserByActiveCode(String activecode) throws SQLException {

        // 1.创建QueryRunner
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        // 2.执行sql语句

        String sql = "select * from users where activecode=?";

        return runner.query(sql, new BeanHandler<User>(User.class), activecode);

    }

    public void activeUserByActivecode(String activecode) throws SQLException {

        // 1.创建QueryRunner
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        // 2.执行sql语句
        String sql = "update users set state=1 where activecode=?";

        runner.update(sql, activecode);
    }

    public User findUserByUserNameAndPassword(String username, String password) throws SQLException {
        // 1.创建QueryRunner
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());

        String sql = "select * from users where username=? and password=?";

        return runner.query(sql, new BeanHandler<User>(User.class), username, Md5Utils.md5(password));
    }
}

