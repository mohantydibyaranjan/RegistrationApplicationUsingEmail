package com.nt.emailUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {
    @Autowired
    private JavaMailSender mailSender;

    public boolean sendEmail(String to, String subject, String body) {
        try {
//          SimpleMailMessage msg = new SimpleMailMessage();
//            msg.setTo(to);
//            msg.setSubject(subject);
//         msg.setText(bo  dy);
//            mailSender.send(msg);
        	MimeMessage message = mailSender.createMimeMessage();
        	MimeMessageHelper mimeMessage=new MimeMessageHelper(message);
        	mimeMessage.setTo(to);
        	mimeMessage.setSubject(subject);
        	mimeMessage.setText(body,true);
   mailSender.send(message);	
        	
        	
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
