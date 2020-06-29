package com.sms.transcript.service.impl;

import com.sms.transcript.dao.ChoiceQstDao;
import com.sms.transcript.dao.impl.ChoiceQstDaoImpl;
import com.sms.transcript.domain.Choice;
import com.sms.transcript.service.ChoiceService;

import java.util.List;

/**
 * @author Chichiu
 * @date 2020/6/14 9:48
 */
public class ChoiceServiceImpl implements ChoiceService {
    //注入Dao
    ChoiceQstDao dao = new ChoiceQstDaoImpl();

    @Override
    public List<Choice> findAllChoice() {
        return dao.findAllChoice();
    }

    public List<String> findAllChoiceAnswer() {
        return dao.findAllChoiceAnswer();
    }

}
