package com.sms.transcript.dao.impl;

import com.sms.base.util.ConnectionFactory;
import com.sms.transcript.dao.ShortQstDao;
import com.sms.transcript.domain.ShortQst;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/***
 * @author chichiu
 * @date 2020/6/14 8:36
 */
public class ShortQstDaoImpl implements ShortQstDao {
    public List<ShortQst> findAllShort() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            //建立到指定数据库 URL 的连接
            conn = ConnectionFactory.getConnection();
            //插入数据库语句
            String sql = "select * from shortqst_info";
            //参数插入数据库
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            //定义一个集合
            List<ShortQst> List = new ArrayList<ShortQst>();
            while (rs.next()) {
                ShortQst shortqst = new ShortQst();
                shortqst.setShortid(rs.getInt("shortqst_id"));
                shortqst.setShorttitle(rs.getString("shortqst_title"));
                shortqst.setShortanswer(rs.getString("shortqst_answer"));
                shortqst.setShortscore(rs.getInt("shortqst_score"));
                //添加到集合里面
                List.add(shortqst);
            }
            return List;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.close(conn, pstm, rs);
        }
    }

    public List<String> findAllShortAnswer() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String answer;
        try {
            //建立到指定数据库 URL 的连接
            conn = ConnectionFactory.getConnection();
            //插入数据库语句
            String sql = "select * from shortqst_info";
            //参数插入数据库
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            //定义一个集合
            List<String> List = new ArrayList<String>();
            while (rs.next()) {
                ShortQst shortqst = new ShortQst();
                shortqst.setShortanswer(rs.getString("shortqst_answer"));
                answer = shortqst.getShortanswer();
                //添加到集合里面
                List.add(answer);
            }
            return List;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.close(conn, pstm, rs);
        }
    }
}
