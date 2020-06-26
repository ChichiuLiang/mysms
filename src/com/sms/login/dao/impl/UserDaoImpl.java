package com.sms.login.dao.impl;


import com.sms.base.util.ConnectionFactory;
import com.sms.login.dao.UserDao;
import com.sms.login.domain.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    /**
     * @param cardid 校园卡
     * @param password 密码
     * @return {@link UserInfo}
     * @author chichiu
     * @date 2020/6/11 12:54
     */
    public UserInfo login(Integer cardid, String password) {

        Connection conn = null;
        PreparedStatement pstm = null;

        //创建实例对象
        UserInfo user = null;
        try {
            ResultSet rs;
            //建立连接
            conn = ConnectionFactory.getConnection();
            //这里的name和password是和数据库里的字段一样的
            String sql = "select * from user where cardid=? and passwd=?";

            //实例化已准备好sql语句的PreparedStatement
            pstm = conn.prepareStatement(sql);

            //这里的username和password是传进来的参数，是带有实际值的，把占位符？号用实际值来替代

            pstm.setInt(1, cardid);
            pstm.setString(2, password);
            System.out.println(sql);
            rs = pstm.executeQuery();

            if (rs.next()) {
                //创建一个user实例，存储查询到的数据
                user = new UserInfo();

                //获取数据库字段
                user.setName(rs.getString("username"));
                user.setCardid(rs.getInt("cardid"));
                user.setPassword(rs.getString("passwd"));

                //验证一下是否取到
                System.out.println(user.getName());
                System.out.println(user.getPassword());
                System.out.println("登录成功");
            } else {
                System.out.println("用户名或者密码错误");
            }
            return user;
        } catch (SQLException e) {
            System.out.println("用户名或者密码错误");
            e.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.close(conn, pstm, null);
        }
    }

    /**
     * @param user 传递一个用户
     * @return {@link boolean}
     * @author chichiu
     * @date 2020/6/11 12:47
     */
    public boolean addUser(UserInfo user) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {

            //建立到指定数据库 URL 的连接
            conn = ConnectionFactory.getConnection();
            //插入数据库语句
            String sql = "insert into user(username,passwd,cardid) values(?,?,?);";
            //参数插入数据库
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, user.getName());
            pstm.setString(2, user.getPassword());
            pstm.setInt(3, user.getCardid());

            //用executeUpdate()可以找到是否行数发生变化，在数据库插入一条数据，会出现影响行数，这里就是那个，所以判断是否等于0
            if (pstm.executeUpdate() != 0) {
                System.out.println("创建新用户成功");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close(conn, pstm, null);
        }

        return false;
    }

//    public boolean checkUser(String username){
//        Connection conn = null;
//        PreparedStatement pstm = null;
//        ResultSet rs-null;
//        try {
//            //建立到指定数据库 URL 的连接
//            conn = ConnectionFactory.getConnection();
//
//            //插入数据库语句
//            String sql = "select username from user where username =?";
//
//            pstm = conn.prepareStatement(sql);
//            pstm.setString(1, username);
//            rs.executeUpdate();
//            if (!rs.next()){
//                System.out.println("用户不存在");
//                return false;
//            }else{
//                return true;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            ConnectionFactory.close(conn, pstm, null);
//        }
//        return false;
//    }

    /***
     *
     * 检测数据库中用户是否注册过
     * @param cardid 校园卡登录验证
     * @param password 传递密码
     * @return {@link byte}  0 数据库中无该用户 ；1 数据库有该用户，但密码错误 ；2 用户和密码匹配
     * @author chichiu
     * @date 2020/6/16 18:56
     */
    public byte checkUser(Integer cardid, String password) {
        Connection conn1 = null;
        Connection conn2 = null;
        PreparedStatement pstm1 = null;
        PreparedStatement pstm2 = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        byte returnnum = 0;
        try {
            //建立到指定数据库 URL 的连接
            conn1 = ConnectionFactory.getConnection();

            //第一次查询数据库 查询该用户是否注册过
            String sql = "select cardid from user where cardid=?";
            pstm1 = conn1.prepareStatement(sql);
            pstm1.setInt(1, cardid);
            rs1 = pstm1.executeQuery();

            conn2 = ConnectionFactory.getConnection();
            //第二次查询数据库 查询该用户和密码是否一致
            String newsql = "select cardid,passwd from user where cardid=? and passwd =?";
            pstm2 = conn2.prepareStatement(newsql);
            pstm2.setInt(1, cardid);
            pstm2.setString(2, password);
            rs2 = pstm2.executeQuery();
            if (rs1.next()) {
                if (rs2.next()) {
                    returnnum = 2;
                } else {
                    returnnum = 1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            if (conn1 != null) {
                //第二次查询，查不到则错误 ， 返回1
                return 1;
            } else {
                //
                return 0;
            }
        } finally {
            if (conn2 != null) {
                ConnectionFactory.close(conn2, pstm2, rs2); //先关闭连接2
            }
            ConnectionFactory.close(conn1, pstm1, rs1); //最后关闭连接1
        }
        return returnnum;
    }
}

