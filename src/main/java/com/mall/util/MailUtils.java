package com.mall.util;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @author Chichiu
 * @date 2020/7/6 7:28
 */
public class MailUtils {
    public static void sendMail(String email, String emailMsg)
            throws AddressException, MessagingException {
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");// 连接协议
        properties.put("mail.smtp.host", "smtp.qq.com");// 邮箱服务器主机名
        properties.put("mail.smtp.port", 465);// 端口号
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");//是否使用ssl安全连接
        properties.put("mail.debug", "true");//是否在控制台显示相关信息

        //获取会话对象
        Session session = Session.getInstance(properties);
        //获取邮件对象
        Message message = new MimeMessage(session);

        try {
            // 设置发件人邮箱地址
            message.setFrom(new InternetAddress("2450138546@qq.com"));
            // 设置收件人邮箱地址
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));

            //有多个收件人时，写成数组形式
            //InternetAddress[] receiverArr={new InternetAddress("xxx@qq.com"),new InternetAddress("xxx@qq.com"),new InternetAddress("xxx@qq.com")};
            //message.setRecipients(Message.RecipientType.TO, receiverArr);

            // 设置邮件标题
            message.setSubject("您已在Mall商城注册用户，请点击邮件下方链接激活账户");
            // 设置邮件内容
            message.setText(emailMsg);

            //获取邮差对象
            Transport transport = session.getTransport();
            //连接自己的邮箱账户，第二个参数是授权码
            transport.connect("2450138546@qq.com", "kzfkfzkweomrecde");
            //发送邮件
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}