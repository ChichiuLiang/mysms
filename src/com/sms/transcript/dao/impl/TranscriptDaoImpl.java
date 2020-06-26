package com.sms.transcript.dao.impl;

import com.sms.base.util.ConnectionFactory;
import com.sms.transcript.dao.TranscriptDao;
import com.sms.transcript.domain.Transcript;
import com.sms.transcript.service.ChoiceService;
import com.sms.transcript.service.ShortQstService;
import com.sms.transcript.service.impl.ChoiceServiceImpl;
import com.sms.transcript.service.impl.ShortQstServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Chichiu
 * @date 2020/6/15 11:54
 */
public class TranscriptDaoImpl implements TranscriptDao {
    //生成成绩单集合
    public List<Transcript> findAllTrans() {
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
            List<Transcript> List = new ArrayList<>();
            while (rs.next()) {
                Transcript trans = new Transcript();
                trans.setChoicenum(rs.getInt("choiceqst_id"));
                trans.setChoiceanswer(rs.getString("shortqst_answer"));
                trans.setChoicescore(rs.getInt("choiceqst_score"));
                trans.setMychoiceanswer(rs.getString("mychoice_answer"));

                trans.setShortnum(rs.getInt("shortqst_id"));
                trans.setShortanswer(rs.getString("shortqst_answer"));
                trans.setShortscore(rs.getInt("shortqst_score"));
                trans.setMyshortanswer(rs.getString("myshort_answer"));

                trans.setScore(rs.getInt("score"));
                trans.setUsername(rs.getString("username"));
                trans.setTranscriptid(rs.getInt("transcript_id"));
                //将实例添加到 List 里面
                List.add(trans);
            }
            return List;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("findAllTrans()有错误");
            return null;
        } finally {
            ConnectionFactory.close(conn, pstm, rs);
        }
    }

    //增加成绩单
    public boolean addTrans(Transcript trans) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {

            //建立到指定数据库 URL 的连接
            conn = ConnectionFactory.getConnection();
            //插入数据库语句
            String sql = "insert into transcript(score,username,mychoice_ans,shortqst_ans," +
                    "myshort_ans,choiceqst_ans,shortget_score,choiceget_score,shortqst_num," +
                    "choiceqst_num) values(?,?,?,?,?,?,?,?,?,?);";
            //参数插入数据库
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, trans.getScore());
            pstm.setString(2, trans.getUsername());
            pstm.setString(3, trans.getMychoiceanswer());
            pstm.setString(4, trans.getShortanswer());
            pstm.setString(5, trans.getMyshortanswer());
            pstm.setString(6, trans.getChoiceanswer());
            pstm.setInt(7, trans.getShortscore());
            pstm.setInt(8, trans.getChoicescore());
            pstm.setInt(9, trans.getShortnum());
            pstm.setInt(10, trans.getChoicenum());

            //用executeUpdate()可以找到是否行数发生变化，在数据库插入一条数据，会出现影响行数
            if (pstm.executeUpdate() != 0) {
                System.out.println("创建成绩单成功");
                return true;
            } else {
                System.out.println("创建成绩失败");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("发生错误！");
            return false;
        } finally {
            ConnectionFactory.close(conn, pstm, null);
        }

    }

    /**
     * 计算总成绩
     *
     * @param trans    传递一个实例对象
     * @param mychoice 请求的选择题的集合
     * @param myshort  请求的简答题的集合
     * @return {@link Transcript} 返回该成绩单的实例对象
     * @author chichiu
     * @date 2020/6/15 22:41
     */
    public Transcript getScore(Transcript trans, List<String> mychoice, List<String> myshort) {
        int score;
        int choicescore = 0;
        int shortscore = 0;
        ChoiceService service = new ChoiceServiceImpl();
        List<String> choiceans = service.findAllChoiceAnswer();
        ShortQstService shortservice = new ShortQstServiceImpl();
        List<String> shortans = shortservice.findAllShortAnswer();
        System.out.println("xxxxxxxxxxxxxxxxx获得分数中xxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("choiceans:" + choiceans);
        System.out.println("shortans:" + shortans);
//        //合并选择题和判断题集合
//        for(int i=0;i<3;i++){
//            choiceans.add(shortans.get(i));
//        }
        for (int i = 0; i < choiceans.size(); i++) {
            String str1 = choiceans.get(i).trim();
            String str2 = mychoice.get(i).trim();
            if (str1.compareTo(str2) != 0) {
                continue;
            }
            choicescore += 20;
        }

        for (int i = 0; i < shortans.size(); i++) {
            String str1 = shortans.get(i).trim();
            String str2 = myshort.get(i).trim();
            if (str1.compareTo(str2) != 0) {
                continue;
            }
            shortscore += 20;
        }
        System.out.println("Shortscore:" + shortscore);
        score = choicescore + shortscore;
        System.out.println(score);

        trans.setMychoiceanswer(String.join(",", mychoice));
        trans.setChoiceanswer(String.join(",", choiceans));
        trans.setMyshortanswer(String.join(",", myshort));
        trans.setShortanswer(String.join(",", shortans));
        trans.setChoicescore(choicescore);
        trans.setShortscore(shortscore);
        trans.setScore(score);

        if (addTrans(trans)) {
            System.out.println("添加成绩单成功！");
        } else {
            System.out.println("添加成绩单失败！");
        }

        return trans;

    }
}
