//package com.sms.transcript.service.impl;
//
//import com.sms.transcript.dao.TranscriptDao;
//import com.sms.transcript.dao.impl.TranscriptDaoImpl;
//import com.sms.transcript.domain.Transcript;
//import com.sms.transcript.service.TransciptService;
//
//import java.util.List;
//
///**
// * @author Chichiu
// * @date 2020/6/15 21:35
// */
//public class TranscriptServiceImpl implements TransciptService {
//    TranscriptDao dao = new TranscriptDaoImpl();
//
//    //生成成绩单集合
//    public List<Transcript> findAllTrans() {
//        return dao.findAllTrans();
//    }
//
//    //增加成绩单
//    public boolean addTrans(Transcript trans) {
//        return dao.addTrans(trans);
//    }
//
//    public Transcript getScore(Transcript trans, List<String> mychoice, List<String> myshort) {
//        return dao.getScore(trans, mychoice, myshort);
//    }
//
//    public Transcript getTransById(Integer id) {
//        return dao.getTransById(id);
//    }
//
//    public List<Integer> findAllTransId() {
//        return dao.findAllTransId();
//    }
//}
