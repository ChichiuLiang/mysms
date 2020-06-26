package com.sms.transcript.servlet;

import com.sms.login.domain.UserInfo;
import com.sms.transcript.domain.Transcript;
import com.sms.transcript.service.TransciptService;
import com.sms.transcript.service.impl.TranscriptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Chichiu
 * @date 2020/6/15 10:09
 */
@WebServlet("/getscore")
public class GetScoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * @param request setCharacterEncoding("utf-8"); //防止接收到前端的中文数据为乱码
         * @param response setCharacterEncoding("utf-8");//防止前端接收到的中文数据为乱码
         */
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String choice1 = request.getParameter("choice1");
        String choice2 = request.getParameter("choice2");
        String saq1 = request.getParameter("saq1");
        String saq2 = request.getParameter("saq2");
        String saq3 = request.getParameter("saq3");
        System.out.println(choice1 + choice2 + saq1 + saq2 + saq3);

        ArrayList<String> mychoice = new ArrayList<String>();
        mychoice.add(choice1);
        mychoice.add(choice2);

        ArrayList<String> myshort = new ArrayList<String>();
        myshort.add(saq1);
        myshort.add(saq2);
        myshort.add(saq3);
        System.out.println("myshort:" + myshort + "mychoice" + mychoice);

        Transcript trans = new Transcript();
        UserInfo user = (UserInfo) request.getSession().getAttribute("loginuser");
        System.out.println("username:" + user.getName());
        trans.setChoicenum(1);
        trans.setShortnum(1);
        trans.setUsername(user.getName());
        TransciptService service = new TranscriptServiceImpl();
        trans = service.getScore(trans, mychoice, myshort);

        //返回一个trans对象，用来查询成绩
        request.getSession().setAttribute("trans", trans);
        request.getRequestDispatcher("/com/sms/transcript/getscore.jsp").forward(request,
                response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
