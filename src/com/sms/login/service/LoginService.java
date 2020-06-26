package com.sms.login.service;

import com.sms.login.domain.UserInfo;

/**
 * @author Chichiu
 * @date 2020/6/15 19:12
 */
public interface LoginService {
    UserInfo login(Integer cardid, String password);

    /**
     * 注册一个用户
     *
     * @param user
     * @return {@link boolean}
     * @throws
     * @author chichiu
     * @date 2020/6/11 12:48
     */
    boolean addUser(UserInfo user);


    /**
     * 检测用户是否存在
     *
     * @param cardid
     * @param password
     * @return {@link byte}
     * @throws
     * @author chichiu
     * @date 2020/6/15 19:35
     */
    byte checkUser(Integer cardid, String password);
}
