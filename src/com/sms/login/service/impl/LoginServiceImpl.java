package com.sms.login.service.impl;

import com.sms.login.dao.UserDao;
import com.sms.login.dao.impl.UserDaoImpl;
import com.sms.login.domain.UserInfo;
import com.sms.login.service.LoginService;

/**
 * @author Chichiu
 * @date 2020/6/15 19:12
 */
public class LoginServiceImpl implements LoginService {
    UserDao dao = new UserDaoImpl();

    public UserInfo login(Integer cardid, String password) {
        return dao.login(cardid, password);
    }

    /**
     * @param user
     * @return {@link boolean}
     * @throws
     * @author chichiu
     * @date 2020/6/11 12:48
     */
    public boolean addUser(UserInfo user) {
        return dao.addUser(user);
    }


    /**
     * 检测是否存在用户
     *
     * @param cardid
     * @param password
     * @return {@link byte}
     * @throws
     * @author chichiu
     * @date 2020/6/15 19:28
     */
    public byte checkUser(Integer cardid, String password) {
        return dao.checkUser(cardid, password);
    }
}
