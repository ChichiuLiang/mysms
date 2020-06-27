package com.sms.transcript.dao;

import com.sms.transcript.domain.Transcript;

import java.util.List;

/**
 * 成绩单处理
 *
 * @author Chichiu
 * @date 2020/6/15 11:23
 */
public interface TranscriptDao {
    //生成成绩单集合
    List<Transcript> findAllTrans();

    //找到所有的试题号
    List<Integer> findAllTransId();

    //增加成绩单
    boolean addTrans(Transcript trans);

    //获取分数
    Transcript getScore(Transcript trans, List<String> mychoice, List<String> myshort);

    //获取某次成绩单
    Transcript getTransById(Integer id);
}
