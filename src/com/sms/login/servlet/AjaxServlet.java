package com.sms.login.servlet;

import com.sms.login.service.LoginService;
import com.sms.login.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Chichiu
 * @date 2020/6/12 21:36
 */
@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //输出到前端页面的一个方法，字符流
        PrintWriter out = response.getWriter();
        //获取jsp页面传递过来的参数信息
        String cardid = request.getParameter("cardid");
        String password = request.getParameter("password");
        byte flagvalue;
        System.out.println(Integer.parseInt(cardid));
        System.out.println(password);
        System.out.println("ajax请求过来了 a--" + request.getParameter("data"));
        if (cardid != null) {
            //调用dao层执行登录sql语句操作，返回为一个user对象
            LoginService login = new LoginServiceImpl();
            flagvalue = login.checkUser(Integer.parseInt(cardid), password);
            System.out.println(flagvalue);
            String json = "{\"flag\":\"" + flagvalue + "\"}";
            System.out.println(json);
            out.write(json);
        } else {
            //返回3，校园卡格式错误
            flagvalue = 3;
            String json = "{\"flag\":\"" + flagvalue + "\"}";
            out.write(json);
        }
        //将user对象转换成json格式的String类型
//        String info=gson.toJson(user);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
