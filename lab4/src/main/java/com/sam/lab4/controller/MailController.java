package com.sam.lab4.controller;

import com.sam.lab4.model.Mail;
import com.sam.lab4.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import java.util.Base64;

@Controller
@RequestMapping("/mail")
public class MailController {
    @Autowired
    MailService mailService;
    @GetMapping ("/test-mail/{id}")
    public String testMail(@PathVariable long id, Model model ){
        try {
            mailService.sendMail(id);
            System.out.println("Send mail Succes");
        } catch (MessagingException e) {
            e.printStackTrace();;
        }
        return "redirect:/user/list";
    }

}
