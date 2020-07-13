//package com.sms.transcript.dao.impl;
//
//import com.mall.util.DataSourceUtils;
//import com.sms.transcript.dao.ChoiceQstDao;
//import com.sms.transcript.domain.Choice;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author Chichiu
// * @date 2020/6/14 6:50
// */
//public class ChoiceQstDaoImpl implements ChoiceQstDao {
//
//    public List<Choice> findAllChoice() {
//        Connection conn = null;
//        PreparedStatement pstm = null;
//        ResultSet rs = null;
//        try {
//            //建立到指定数据库 URL 的连接
//            conn = DataSourceUtils.getConnection();
//            //插入数据库语句
//            String sql = "select * from choiceqst_info";
//            //参数插入数据库
//            pstm = conn.prepareStatement(sql);
//            rs = pstm.executeQuery();
//
//            //定义一个集合
//            List<Choice> List = new ArrayList<Choice>();
//            while (rs.next()) {
//                Choice choice = new Choice();
//                System.out.println(rs.getInt("choiceqst_id"));
//                choice.setChoiceid(rs.getInt("choiceqst_id"));
//                choice.setChoicetitle(rs.getString("choiceqst_title"));
//                choice.setChoiceop1(rs.getString("choiceqst_op1"));
//                choice.setChoiceop2(rs.getString("choiceqst_op2"));
//                choice.setChoiceop3(rs.getString("choiceqst_op3"));
//                choice.setChoiceop4(rs.getString("choiceqst_op4"));
//                choice.setChoicescore(rs.getInt("choiceqst_score"));
//
//                String content = "";
//                content = rs.getString("choiceqst_answer");
//                choice.setChoiceanswer(content);
//                System.out.println("\n content：" + content);
//                //添加到集合里面
//                List.add(choice);
//            }
////            return List;/**/
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        } finally {
//            DataSourceUtils.close(conn, pstm, rs);
//        }
//    }
//
//    public List<String> findAllChoiceAnswer() {
//        Connection conn = null;
//        PreparedStatement pstm = null;
//        ResultSet rs = null;
//        String answer;
//        try {
//            //建立到指定数据库 URL 的连接
//            conn = DataSourceUtils.getConnection();
//            //插入数据库语句
//            String sql = "select * from choiceqst_info";
//            //参数插入数据库
//            pstm = conn.prepareStatement(sql);
//            rs = pstm.executeQuery();
//
//            //定义一个集合
//            List<String> list = new ArrayList<String>();
//            while (rs.next()) {
//                //添加到集合里面
//                Choice choice = new Choice();
//                String content = "";
//                content = rs.getString("choiceqst_answer");
//                choice.setChoiceanswer(content);
//                list.add(content);
//            }
//            return list;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return null;
//        } finally {
//            DataSourceUtils.close(conn, pstm, rs);
//        }
//    }
//
//}
