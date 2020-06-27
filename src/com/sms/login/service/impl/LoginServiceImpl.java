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
    public UserDao dao = new UserDaoImpl();

    public UserInfo login(Integer cardid, String password) {
        return dao.login(cardid, password);
    }

    /**
     * @param user 传递一个对象
     * @return {@link boolean}
     * @author chichiu
     * @date 2020/6/11 12:48
     */
    public boolean addUser(UserInfo user) {
        return dao.addUser(user);
    }


    /**
     * 检测是否存在用户
     *
     * @param cardid 校园卡
     * @param password 密码
     * @return {@link byte}
     * @author chichiu
     * @date 2020/6/15 19:28
     */
    public byte checkUser(Integer cardid, String password) {
        return dao.checkUser(cardid, password);
    }
}
