package com.mall.goods.service.impl;

import com.mall.exception.PrivilegeException;
import com.mall.goods.dao.ProductDao;
import com.mall.goods.domain.Product;
import com.mall.goods.service.ProductService;
import com.mall.login.domain.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Chichiu
 * @date 2020/7/5 14:14
 */
public class ProductServiceImpl implements ProductService {

    // 添加商品
    public void add(User user, Product product) throws PrivilegeException,
            SQLException {

        ProductDao dao = new ProductDao();

        dao.addProduct(product);

    }

    // 查找所有商品
//    @Test
    public List<Product> findAll() throws SQLException {
        ProductDao dao = new ProductDao();
        return dao.findAll();
    }


    // 根据id查找商品
    public Product findById(String id) throws SQLException {
        ProductDao dao = new ProductDao();
        return dao.findById(id);
    }

    // 得到销售榜单信息
    public List<Product> findSell(User user) throws PrivilegeException,
            SQLException {
        ProductDao dao = new ProductDao();
        return dao.findSell();
    }
}
