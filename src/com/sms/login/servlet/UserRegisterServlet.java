package com.sms.login.servlet;

import com.sms.login.domain.UserInfo;
import com.sms.login.service.LoginService;
import com.sms.login.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class UserRegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //项目根路径
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";

        /*获取register.jsp页面提交的账号和密码*/
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String cardid = request.getParameter("cardid");

        LoginService login = new LoginServiceImpl();
        UserInfo user = new UserInfo();

        user.setName(username);
        user.setPassword(password);
        user.setCardid(Integer.parseInt(cardid));
        //判断是否加入成功
        if (login.addUser(user)) {
            System.out.println("即将跳回到登录页面");
            request.setAttribute("msg", "注册用户成功");
            request.setAttribute("url", basePath + "index.jsp");
            request.getRequestDispatcher(basePath + "jump.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", "注册用户失败");
            request.setAttribute("url", basePath + "com/sms/login/register.jsp");
            request.getRequestDispatcher(basePath + "jump.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
