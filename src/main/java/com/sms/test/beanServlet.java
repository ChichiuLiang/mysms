//package com.sms.test;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
///**
// * @author Chichiu
// * @date 2020/6/24 13:07
// */
//@WebServlet("/getbeans")
//public class beanServlet extends HttpServlet {
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=utf-8");
////获取前端传递的参数
//
//
//        String stunum ="20170390105";
//        String name = "卢毅豪";
//        String score = "100";
//
//        //存储数据
//        Score scorebean=new Score(Integer.parseInt(score),name,stunum);
//
//        request.setAttribute("scorebean",scorebean);
//        request.getRequestDispatcher("showscore.jsp").forward(request,
//                response);
//    }
//}
