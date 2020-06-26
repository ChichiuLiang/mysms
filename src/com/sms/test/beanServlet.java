package com.sms.test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Chichiu
 * @date 2020/6/24 13:07
 */
@WebServlet("/getbeans")
public class beanServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String firstname = "chichiu";
        String lastname = "liang";
        Integer age = 22;
        StudentsBean stu = new StudentsBean();
        stu.setAge(20);
        stu.setFirstName(firstname);
        stu.setLastName(lastname);
        System.out.println(stu);
        System.out.println(stu.getFirstName());
        HttpSession session = request.getSession();
        synchronized (session) {
            session.setAttribute("stu", stu);
        }

        request.getRequestDispatcher("/com/sms/test/test.jsp").forward(request, response);
    }
}
