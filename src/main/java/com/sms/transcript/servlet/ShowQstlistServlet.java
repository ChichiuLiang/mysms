//package com.sms.transcript.servlet;
//
//import com.sms.transcript.domain.Choice;
//import com.sms.transcript.domain.ShortQst;
//import com.sms.transcript.service.ChoiceService;
//import com.sms.transcript.service.ShortQstService;
//import com.sms.transcript.service.impl.ChoiceServiceImpl;
//import com.sms.transcript.service.impl.ShortQstServiceImpl;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
///**
// * @author Chichiu
// * @date 2020/6/14 10:35
// */
//@WebServlet("/showqstlist")
//public class ShowQstlistServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    /**
//     * @see HttpServlet
//     */
//    public ShowQstlistServlet() {
//        super();
//    }
//
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html;charset=utf-8");
//        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
//
//
////
////        // printWriter
////        PrintWriter out = response.getWriter();
//
//        //
//        ChoiceService service = new ChoiceServiceImpl();
//
//        List<Choice> choicelist = service.findAllChoice();
//
//        ShortQstService shortservice = new ShortQstServiceImpl();
//
//        List<ShortQst> shortlist = shortservice.findAllShort();
//        //将list集合对象输出到前端页面
//        request.setAttribute("choicelist", choicelist);
//        request.setAttribute("shortlist", shortlist);
//        System.out.println("/com/sms/transcript/testlist.jsp");
//        request.getRequestDispatcher("/com/sms/transcript/testlist.jsp").forward(request,
//                response);
//
//
//    }
//}
