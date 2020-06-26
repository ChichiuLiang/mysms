package com.sms.transcript.service;

import com.sms.transcript.domain.ShortQst;

import java.util.List;

/**
 * @author Chichiu
 * @date 2020/6/14 10:57
 */
public interface ShortQstService {
    List<ShortQst> findAllShort();

    List<String> findAllShortAnswer();
}
