package com.sms.file.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Chichiu
 * @date 2020/6/20 15:17
 */
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UploadServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        //获得一个文件上传的工厂类
        DiskFileItemFactory dfif = new DiskFileItemFactory();//DiskFileItemFactory 是创建 FileItem 对象的工厂

        //设置文件上传临时存储的大小8M
        dfif.setSizeThreshold(1024 * 1024 * 8);

        //指定临时文件目录，默认值为当前用户的系统临时文件目录，可通过System.getProperty(“java.io.tmpdir”)打印查看；
        dfif.setRepository(new File("java.io.tmpdir"));
        System.out.println(System.getProperty("java.io.tmpdir"));

        //使用servlet来处理文件上传，创建一个文件上传的实例对象
        ServletFileUpload upload = new ServletFileUpload(dfif);

        //设置文件上传的大小为10M
        upload.setSizeMax(1024 * 1024 * 10);

        //获取当前服务器的路径
        String uploadPath = this.getServletContext().getRealPath("");
        System.out.println("当前服务器路径---->" + uploadPath);
        uploadPath = uploadPath + "..\\..\\..\\" + "upload";


        File uploadDir = new File(uploadPath);
        //如果WEB-INF下面的upload文件夹不存在，则新建一个upload文件夹
        if (!uploadDir.exists()) uploadDir.mkdir();
        try {
            //将所有要上传的文件存到文件集合里面
            List<FileItem> formItem = upload.parseRequest(request);

            //如果上传的文件不为空
            if (formItem != null && formItem.size() > 0) {

                //循环遍历要上传的文件
                for (FileItem item : formItem) {
                    if (!item.isFormField()) {

                        //获得要上传的文件的名字
                        String fileName = new File(item.getName()).getName();
                        //fileName = new Date().getTime()+(int)(Math.random()*100)+fileName;

                        //目的文件
                        String filePath = uploadPath + "\\" + fileName;
                        File storeFile = new File(filePath);
                        item.write(storeFile);

                        System.out.println(fileName);
                        System.out.println(filePath);
                        //request.setAttribute("fileName", fileName);
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
            request.setAttribute("msg", "文件上传失败:" + e.getMessage());
            request.setAttribute("url", "/com/sms/file/upload.jsp");
            request.getRequestDispatcher("/jump.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("msg", "文件上传成功");
        request.setAttribute("url", "/com/sms/file/upload.jsp");
        request.getRequestDispatcher("/jump.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
