package com.depot.app.service.impl;

import com.depot.app.model.Feedback;
import com.depot.app.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

/**
 * Created by steven on 2014/08/01.
 */
@Component
public class EmailServiceImpl implements EmailService{

    private MailSender mailSender;

    public EmailServiceImpl(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public EmailServiceImpl() {
    }

    @Override
    public void send(Feedback feedback) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(feedback.getEmail());
        simpleMailMessage.setTo("stevenndaye@gmail.com");
        simpleMailMessage.setSubject("Depot Application Queries");
        simpleMailMessage.setText(feedback.getComments());

        mailSender.send(simpleMailMessage);

    }
}
