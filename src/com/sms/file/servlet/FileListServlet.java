package com.sms.file.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chichiu
 * @date 2020/6/20 16:59
 */
@WebServlet("/filelist")
public class FileListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //登录验证
        HttpSession session = request.getSession();
        //若用户没有登录则返回登录页面
        if (session == null || session.getAttribute("loginuser") == null) {
            request.setAttribute("msg", "未登录系统。请先登录");
            request.setAttribute("url", "/index.jsp");
            request.getRequestDispatcher("/jump.jsp").forward(request, response);
            return;
        }

        //获取文件上传目录
        String uploadFilePath = this.getServletContext().getRealPath("");
        System.out.println("当前服务器路径---->" + uploadFilePath);
        uploadFilePath = uploadFilePath + "..\\..\\..\\" + "upload";
        System.out.println(uploadFilePath);

        //以HashMap的形式 存储要下载的文件的文件名
        HashMap<String, String> fileNameMap = new HashMap<>();

        //递归遍历filepath 目录下的所有文件和目录，
        listfile(new File(uploadFilePath), fileNameMap);

        //传递一个fileNameMap的对象，转到下载页面
        request.setAttribute("fileNameMap", fileNameMap);
        request.getRequestDispatcher("/com/sms/file/download.jsp").forward(request,
                response);

    }

    private void listfile(File file, Map<String, String> fileNameMap) {
        //如果file代表的是一个目录，而不是文件
        if (!file.isFile()) {
            /* 列出该目录下面的所有文件和目录 */
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    //递归每一个文件或目录
                    listfile(f, fileNameMap);
                }
            }

        } else {
            //
            String realName = file.getName().substring(file.getName().indexOf("_") + 1);
            fileNameMap.put(file.getName(), realName);
        }
    }
}
