package com.sms.transcript.servlet;

import com.sms.transcript.service.TransciptService;
import com.sms.transcript.service.impl.TranscriptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Chichiu
 * @date 2020/6/26 21:29
 */
@WebServlet("/showTransId")
public class ShowTransIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        TransciptService service = new TranscriptServiceImpl();
        List<Integer> transidlist = service.findAllTransId();
        //输出到前端页面的一个方法，字符流
        request.getSession().setAttribute("transidlist", transidlist);
        System.out.println(transidlist);
        request.getRequestDispatcher("/com/sms/transcript/querytrans.jsp").forward(request,
                response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
