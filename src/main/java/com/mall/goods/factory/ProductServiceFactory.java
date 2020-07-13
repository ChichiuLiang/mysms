package com.mall.goods.factory;

import com.mall.exception.PrivilegeException;
import com.mall.goods.service.ProductService;
import com.mall.goods.service.impl.ProductServiceImpl;
import com.mall.login.domain.User;
import com.mall.privilege.PrivilegeInfo;
import com.mall.privilege.dao.PrivilegeDao;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Chichiu
 * @date 2020/7/5 14:20
 */
public class ProductServiceFactory {

    private static ProductService service = new ProductServiceImpl();

    public static ProductService getInstance() {
//        动态代理（dynamic proxy）
//        利用Java的反射技术(Java Reflection)，在运行时创建一个实现某些给定接口的新类（也称“动态代理类”）及其实例（对象）,代理的是接口(Interfaces)，不是类(Class)，也不是抽象类。在运行时才知道具体的实现，spring aop就是此原理。
//        public static Object newProxyInstance(ClassLoader loader,
//                Class<?>[] interfaces,
//                InvocationHandler h)
//        throws IllegalArgumentException


        return (ProductService) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(),
                new InvocationHandler() {

                    public Object invoke(Object proxy, Method method,
                                         Object[] args) throws IllegalAccessException,
                            IllegalArgumentException, InvocationTargetException {


                        // 1.判断是否有注解
                        if (method.isAnnotationPresent(PrivilegeInfo.class)) {
                            // 2。得到注册对象
                            PrivilegeInfo pif = method.getAnnotation(PrivilegeInfo.class);
                            // 3.得到权限名称
                            String pname = pif.value();

                            // 4.得到用户
                            User user = (User) args[0];

                            if (user == null) {
                                System.out.println("权限不足");
                                throw new PrivilegeException(); // 抛出权限不足异常
                            }


                            // 5.根据用户查询是否具有权限
                            PrivilegeDao pdao = new PrivilegeDao();
                            if (!pdao.checkPrivilege(user.getRole(), pname)) {
                                System.out.println("// 抛出权限不足异常");
                                throw new PrivilegeException(); // 抛出权限不足异常

                            }

                        }

                        return method.invoke(service, args);

                    }
                });

    }
}
