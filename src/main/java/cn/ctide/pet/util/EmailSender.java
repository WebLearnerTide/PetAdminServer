package cn.ctide.pet.util;

import java.util.Date;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;

public class EmailSender extends JavaMailSenderImpl {
	
	public String sendResetCode(String to) throws Exception {
    	String subject = "重置密码";
    	String resetCode = ReturnCodeGenerator.INSTANCE.getCode();
    	StringBuffer message = new StringBuffer("您的验证码为：<b style=\"color:red\">").append(resetCode).append("</b><br>请不要将验证码告诉别人哦！");
//    	OSS.INSTANCE.addReturnCode(to, resetCode);
    	MimeMessage simpleMailMessage = new MimeMessage(getSession());
    	simpleMailMessage.setFrom(new InternetAddress(getUsername()));
    	simpleMailMessage.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
    	simpleMailMessage.setSubject(subject);
    	simpleMailMessage.setContent(message.toString(), "text/html;charset=UTF-8");
    	simpleMailMessage.setSentDate(new Date());
    	this.send(simpleMailMessage);
    	return resetCode;
    }
}
