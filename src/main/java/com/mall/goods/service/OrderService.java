package com.mall.goods.service;

import com.mall.exception.OrderException;
import com.mall.exception.PrivilegeException;
import com.mall.goods.domain.Order;
import com.mall.login.domain.User;
import com.mall.privilege.PrivilegeInfo;

import java.util.List;

/**
 * @author Chichiu
 * @date 2020/7/4 10:04
 */
public interface OrderService {

    // 添加订单
    @PrivilegeInfo("生成订单")
    public void add(User user, Order order) throws PrivilegeException,
            Exception;

    // 根据用户查找订单
    @PrivilegeInfo("查看订单")
    public List<Order> find(User user) throws PrivilegeException, Exception;

    // 根据id删除订单
    public void delete(String id) throws Exception, OrderException;

    public void updateState(String id) throws Exception;
}
