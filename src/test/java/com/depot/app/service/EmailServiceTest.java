package com.depot.app.service;

import com.depot.app.model.Feedback;
import com.depot.app.service.impl.EmailServiceImpl;
import org.apache.velocity.app.VelocityEngine;
import org.jmock.auto.Mock;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.internet.MimeMessage;

import java.util.Date;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by steven on 2014/08/01.
 */
public class EmailServiceTest {


    private JavaMailSender mailSender;
    private Feedback feedback;
    private EmailService emailService;
    private SimpleMailMessage simpleMailMessage;
    private VelocityEngine velocityEngine;
    private MimeMessage mimeMailMessage;

    @Before
    public void setUp(){
        feedback = setUpFeedBack();
        setUpFeedBack();
        mailSender = mock(JavaMailSender.class);
        mimeMailMessage = mock(MimeMessage.class);
        velocityEngine = mock(VelocityEngine.class);
        emailService = new EmailServiceImpl(mailSender, velocityEngine);
    }

    private Feedback setUpFeedBack() {
        Feedback feedback = new Feedback();

        feedback.setFullName("Steven Ndaye");
        feedback.setEmail("stevenndaye@gmail.com");
        feedback.setComments("Comments");
        feedback.setDate(new Date());

        return feedback;
    }

    @Test
    public void itShouldSendEmail(){
        when(mailSender.createMimeMessage()).thenReturn(mimeMailMessage);
        emailService.send(feedback);
        simpleMailMessage = new SimpleMailMessage();
        setUpSimpleMailMessage();
        verify(mailSender).send(simpleMailMessage);
        verify(mailSender).send(mimeMailMessage);
    }

    private void setUpSimpleMailMessage() {
        simpleMailMessage.setFrom(feedback.getEmail());
        simpleMailMessage.setTo("stevenndaye@gmail.com");
        simpleMailMessage.setSubject("Depot Application Queries");
        simpleMailMessage.setText(feedback.getComments());
    }
}
