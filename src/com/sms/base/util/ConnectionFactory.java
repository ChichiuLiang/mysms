package com.sms.base.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import com.mysql.jdbc.Connection; 注意是java.sql.Connection这个包，不然报错

public class ConnectionFactory {
    private static DataSource ds;

    // 初始化C3P0数据源
    static {
        // 使用c3p0-config.xml配置文件中的named-config节点中name属性的值
        ds = new ComboPooledDataSource("webappDS");
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

//    //关闭数据源，一般不用调用该方法
//    public static void closeDataSource() throws Exception {
//        ds.getClass().getMethod("close").invoke(ds);
//    }

    //关闭连接方法
    public static void close(Connection con, PreparedStatement pstm, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            if (pstm != null) pstm.close();
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //mysql数据库驱动
//    private static String DRIVER = "com.mysql.jdbc.Driver";
//    private static String URL = "jdbc:mysql://localhost:3305/test?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
//    private static String USER= "root";
//    private static String PASSWORD = "1234";
//    /**
//     *
//     *
//     * @return {@link Connection}
//     * @throws
//     * @author chichiu
//     * @date 2020/6/11 12:50
//     */
//    public static Connection getConnection(){
//        try {
//            Class.forName(DRIVER);
//            // @2
//            System.out.println("———————— 数据库连接 成功 ————————");
//            Connection con = (Connection) DriverManager.getConnection(URL,USER,PASSWORD);
//            return con;
//        } catch (Exception e) {
//            System.out.println("———————— 数据库连接 失败 ————————");
//            e.printStackTrace();
//            return null;
//        }
//    }
}
