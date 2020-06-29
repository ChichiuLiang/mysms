package com.sms.transcript.servlet;

import com.sms.transcript.domain.Transcript;
import com.sms.transcript.service.TransciptService;
import com.sms.transcript.service.impl.TranscriptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Chichiu
 * @date 2020/6/26 17:11
 */
@WebServlet("/queryTrans")
public class QueryTransServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String transcript_id = request.getParameter("transcript_id");
        System.out.println("id" + transcript_id);

        TransciptService service = new TranscriptServiceImpl();
        System.out.println("Integer.parseInt(transcript_id)" + Integer.parseInt(transcript_id));
        Transcript trans = service.getTransById(Integer.parseInt(transcript_id));

        request.setAttribute("trans", trans);
        request.getRequestDispatcher("/com/sms/transcript/querytrans.jsp").forward(request,
                response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        this.doPost(request, response);
    }
}
