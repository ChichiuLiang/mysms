package com.sms.file.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * @author Chichiu
 * @date 2020/6/20 15:30
 */
@WebServlet("/downloads")
public class DownloadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DownloadServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");


//        HttpSession session =request.getSession();
//        //若用户没有登录则返回登录页面
//        if (session==null || session.getAttribute("loginuser")==null){
//            request.setAttribute("msg","未登录系统。请先登录");
//            request.setAttribute("url","index.jsp");
//            request.getRequestDispatcher("/jump.jsp").forward(request,response);
//            return;
//        }

        //得到要下载的文件名
        String fileName = request.getParameter("filename");

        //获取上传的文件路径
        String uploadPath = this.getServletContext().getRealPath("");
        System.out.println("服务器路径:----" + uploadPath);
        uploadPath = uploadPath + "..\\..\\..\\" + "upload";

        //通过文件名找出文件的所在目录
//        String path = findFilePathByFileName(fileName,uploadPath);

        //得到要下载的文件
        File file = new File(uploadPath + "\\" + fileName);

        //如果文件不存在
        if (!file.exists()) {
            request.setAttribute("msg", "你要下载的资源不存在！");
            request.setAttribute("url", "/com/sms/file/download.jsp");
            request.getRequestDispatcher("/jump.jsp").forward(request, response);

        }
//        //处理文件名
//        String realname = fileName.substring(fileName.indexOf("_")+1);

        //设置响应头，控制浏览器下载该文件
        response.setHeader("content-disposition",
                "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        //读取要下载的文件，保存到文件输入流
        FileInputStream in = new FileInputStream(uploadPath + "\\" + fileName);
        //创建输出流
        OutputStream out = response.getOutputStream();

        //创建缓冲区
        byte[] buffer = new byte[1024];
        int len;
        //循环将输入流中的内容读取到缓冲区当中
        while ((len = in.read(buffer)) > 0) {
            //输出缓冲区的内容到浏览器，实现文件下载
            out.write(buffer, 0, len);
        }
        //关闭文件输入流
        in.close();
        //关闭输出流
        out.close();
    }

//    public String findFilePathByFileName(String fileName, String fileSaveRootPath) {
//        int hashcode = fileName.hashCode();
////        int dir1 = hashcode&0xf;  //0--15
////        int dir2 = (hashcode&0xf0)>>4;  //0-15
////        String dir = fileSaveRootPath + "\\" + dir1 + "\\" + dir2;  //upload\2\3  upload\3\5
//        File file = new File(dir);
//        if(!file.exists()){
//            //创建目录
//            file.mkdirs();
//        }
//        return dir;
//    }


}
