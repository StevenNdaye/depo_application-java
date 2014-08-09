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

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by steven on 2014/08/01.
 */
public class EmailServiceTest {


    private JavaMailSender mailSender;
    private Feedback feedback;
    private EmailService emailService;
    private SimpleMailMessage simpleMailMessage;
    private VelocityEngine velocityEngine;

    @Before
    public void setUp(){
        feedback = setUpFeedBack();
        setUpFeedBack();
        mailSender = mock(JavaMailSender.class);
        velocityEngine = mock(VelocityEngine.class);
        emailService = new EmailServiceImpl(mailSender, velocityEngine);
    }

    private Feedback setUpFeedBack() {
        return new Feedback(){{
            setFullName("Steven Ndaye");
            setEmail("stevenndaye@gmail.com");
            setComments("Comments");
        }};
    }

    @Test
    @Ignore
    public void itShouldSendEmail(){
        emailService.send(feedback);
        simpleMailMessage = new SimpleMailMessage();
        setUpSimpleMailMessage();
        verify(mailSender).send(simpleMailMessage);
    }

    private void setUpSimpleMailMessage() {
        simpleMailMessage.setFrom(feedback.getEmail());
        simpleMailMessage.setTo("stevenndaye@gmail.com");
        simpleMailMessage.setSubject("Depot Application Queries");
        simpleMailMessage.setText(feedback.getComments());
    }
}
