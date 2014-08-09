package com.depot.app.service;

import com.depot.app.model.Feedback;
import com.depot.app.service.impl.EmailServiceImpl;
import org.jmock.auto.Mock;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by steven on 2014/08/01.
 */
public class EmailServiceTest {


    private MailSender mailSender;
    private Feedback feedback;
    private EmailService emailService;
    private SimpleMailMessage simpleMailMessage;

    @Before
    public void setUp(){
        feedback = setUpFeedBack();
        setUpFeedBack();
        mailSender = mock(MailSender.class);
        emailService = new EmailServiceImpl(mailSender);
    }

    private Feedback setUpFeedBack() {
        return new Feedback(){{
            setFullName("Steven Ndaye");
            setEmail("stevenndaye@gmail.com");
            setComments("Comments");
        }};
    }

    @Test
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