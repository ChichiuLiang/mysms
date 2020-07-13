package com.mall.goods.servlet;

import com.mall.goods.domain.Order;
import com.mall.goods.service.OrderService;
import com.mall.login.domain.User;
import com.mall.util.OrderServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Chichiu
 * @date 2020/7/6 9:04
 */
@WebServlet("/showorder")
public class ShowOrderServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1.得到当前用户
        User user = (User) request.getSession().getAttribute("user");

        if (user == null) {
            response.getWriter().write(
                    "请先<a href='" + request.getContextPath()
                            + "/index.jsp'>登录</a>");
            return;
        }

        // 2.调用OrderService中查询订单操作
        OrderService service = OrderServiceFactory.getInstance();

        try {
            List<Order> orders = service.find(user);

            request.setAttribute("orders", orders);

            request.getRequestDispatcher("/showOrder.jsp").forward(request,
                    response);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}

