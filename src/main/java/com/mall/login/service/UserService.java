package com.mall.login.service;

import com.mall.exception.RegistException;
import com.mall.login.domain.User;

/**
 * @author Chichiu
 * @date 2020/7/6 7:20
 */
public interface UserService {
    // 注册操作
    public void regist(User user) throws Exception, RegistException;

    // 登录操作
    public User login(String username, String password) throws Exception;

    // 激活操作
    public void activeUser(String activecode) throws Exception;
}

