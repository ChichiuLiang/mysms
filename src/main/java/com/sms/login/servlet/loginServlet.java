//package com.sms.login.servlet;
//
//import com.sms.login.domain.UserInfo;
//import com.sms.login.service.LoginService;
//import com.sms.login.service.impl.LoginServiceImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.*;
//import java.io.IOException;
//
//@WebServlet("/login")
//public class loginServlet extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        this.doPost(request, response);
//    }
//
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//
//
////         * @param request setCharacterEncoding("utf-8"); //防止接收到前端的中文数据为乱码
////         * @param response setCharacterEncoding("utf-8");//防止前端接收到的中文数据为乱码
//        response.setContentType("text/html");
//        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
//
//        //项目根路径
//        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
//
////        //输出到前端页面的一个方法，字符流
////        PrintWriter out = response.getWriter();
//
//
////         * 获取前端的参数
////         * getParameter("username")
////         * getParameter("password")
//        String cardid = request.getParameter("cardid");
//        String password = request.getParameter("password");
//
//        //打印request传递的参数
//        System.out.println(cardid + "  " + password);
//
//        //实例化userDao
//        LoginService login = new LoginServiceImpl();
//
//        //调用LoginService服务接口，返回为一个user对象
//        UserInfo user = login.login(Integer.parseInt(cardid), password);
//
//        if (user != null) {
//            // 如果用户登录成功
//            HttpSession session = request.getSession();
//            // 手动设置session的有效期为30分钟
//            String sessionId = session.getId();
//            Cookie cookie = new Cookie("JSESSIONID", sessionId);
//            cookie.setMaxAge(60 * 30);
//            cookie.setPath(request.getContextPath());
//            response.addCookie(cookie);
//
//            // 登录成功后要存入用户的登录状态，key是用户对象的String形式value就是用户对象(model)
//            session.setAttribute("loginuser", user);
//            // 重定向到首页，URL重写方式
//            String url = response.encodeRedirectURL(basePath + "com/sms/login/login.jsp");
//            response.sendRedirect(url);
//            System.out.println(session.getAttribute("loginuser").toString());
//        } else {
//            // 没登录，重定向到首页
//            System.out.println(basePath);
//            request.setAttribute("msg", "文件上传成功");
//            request.setAttribute("url", basePath + "index.jsp");
//            request.getRequestDispatcher("jump.jsp").forward(request, response);
//        }
//
////        //利用gson工具将我们的user封装成json数据格式
////        Gson gson = new Gson();
////        //将user对象转换成json格式的String类型
////        String info=gson.toJson(user);
////        //处理后数据到控制台
////        System.out.println(info);
////        request.getRequestDispatcher("login.jsp").forward(request,response);
//        //将数据返回前端页面
////        out.write(info);
//        //关闭字符流
////        out.flush();
////        out.close();
//    }
//}