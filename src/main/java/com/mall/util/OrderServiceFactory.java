package com.mall.util;

import com.mall.exception.PrivilegeException;
import com.mall.goods.service.OrderService;
import com.mall.goods.service.impl.OrderServiceImpl;
import com.mall.login.domain.User;
import com.mall.privilege.PrivilegeInfo;
import com.mall.privilege.dao.PrivilegeDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Chichiu
 * @date 2020/7/4 10:03
 */
public class OrderServiceFactory {
    private static OrderService service = new OrderServiceImpl();

    public static OrderService getInstance() {

        return (OrderService) Proxy.newProxyInstance(service.getClass()
                        .getClassLoader(), service.getClass().getInterfaces(),
                new InvocationHandler() {

                    public Object invoke(Object proxy, Method method,
                                         Object[] args) throws IllegalAccessException,
                            IllegalArgumentException, InvocationTargetException {
                        // 1.判断是否有注解
                        if (method.isAnnotationPresent(PrivilegeInfo.class)) {
                            // 2。得到注册对象
                            PrivilegeInfo pif = method
                                    .getAnnotation(PrivilegeInfo.class);
                            // 3.得到权限名称
                            String pname = pif.value();

                            // 4.得到用户
                            User user = (User) args[0];

                            if (user == null) {
                                throw new PrivilegeException();
                            }
                            // 5.根据用户查询是否具有权限
                            PrivilegeDao pdao = new PrivilegeDao();
                            if (!pdao.checkPrivilege(user.getRole(), pname)) {
                                throw new PrivilegeException(); // 抛出权限不足异常

                            }

                        }

                        return method.invoke(service, args);

                    }
                });

    }
}
