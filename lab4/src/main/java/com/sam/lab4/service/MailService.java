package com.sam.lab4.service;

import com.sam.lab4.model.Mail;
import com.sam.lab4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.ISpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private ISpringTemplateEngine springTemplateEngine;
    @Autowired
    private UserRepository  userRepository;

    public void sendMail(long id) throws MessagingException {
        String email = userRepository.getById(id).getEmail();
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper= new MimeMessageHelper(message,MimeMessageHelper.MULTIPART_MODE_MIXED,"UTF-8");
        Context context= new Context();
        String html= springTemplateEngine.process("email-template",context);
        mimeMessageHelper.setFrom("dinhngocminhhieu@gmail.com");
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("hello new");
        mimeMessageHelper.setText(html,true);
        javaMailSender.send(message);
    }
}
