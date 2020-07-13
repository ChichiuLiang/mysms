package com.mall.goods.service;

import com.mall.exception.PrivilegeException;
import com.mall.goods.domain.Product;
import com.mall.login.domain.User;
import com.mall.privilege.PrivilegeInfo;

import java.util.List;

/**
 * @author Chichiu
 * @date 2020/7/5 14:15
 */
public interface ProductService {
    // 添加商品
    @PrivilegeInfo("添加商品")
    public void add(User user, Product product) throws PrivilegeException,
            Exception;

    // 查找商品
    public List<Product> findAll() throws Exception;

    // 根据id查找商品
    public Product findById(String id) throws Exception;

    // 查询销售榜单
    @PrivilegeInfo("下载榜单")
    public List<Product> findSell(User user) throws PrivilegeException,
            Exception;
}
