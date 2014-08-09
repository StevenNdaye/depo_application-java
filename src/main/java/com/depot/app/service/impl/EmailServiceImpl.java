package com.depot.app.service.impl;

import com.depot.app.model.Feedback;
import com.depot.app.service.EmailService;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import javax.mail.MessagingException;

/**
 * Created by steven on 2014/08/01.
 */
@Component
public class EmailServiceImpl implements EmailService{

    private static final String CONFIRMATION_TEMPLATE_PATH = "contactConfirm.vm";
    private JavaMailSender mailSender;
    private VelocityEngine velocityEngine;

    private boolean sendConfirmation = true;


    public EmailServiceImpl(JavaMailSender mailSender, VelocityEngine velocityEngine) {
        this.mailSender = mailSender;
        this.velocityEngine = velocityEngine;
    }

    public EmailServiceImpl() {
    }

    @Override
    public void send(Feedback feedback) {
        sendActualEmail(feedback);
        sendConfirmationEmail(feedback);
    }

    private void sendActualEmail(Feedback feedback) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(feedback.getEmail());
        simpleMailMessage.setTo("stevenndaye@gmail.com");
        simpleMailMessage.setSubject("Depot Application Queries");
        simpleMailMessage.setText(feedback.getComments());
        mailSender.send(simpleMailMessage);
    }

    private void sendConfirmationEmail(Feedback feedback) {
        if(sendConfirmation){
            MimeMessage mimeMessage = createEmail(feedback, CONFIRMATION_TEMPLATE_PATH, "Depot Application Queries");

            mailSender.send(mimeMessage);
        }
    }

    private MimeMessage createEmail(Feedback feedback, String template, String subject){
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("feedback", feedback);

        String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, template, model);
        text = text.replaceAll("\n", "<br>");

        try{
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setSubject(subject);
            helper.setTo(feedback.getEmail());

            if(feedback.getEmail() == null ){
                helper.setFrom("stevenndaye@gmail.com");
            } else {
                try {
                    helper.setFrom("stevenndaye@gmail.com", "Steven Ndaye");
                } catch (UnsupportedEncodingException e){
                    helper.setFrom("stevenndaye@gmail.com");
                }
            }
            helper.setSentDate(feedback.getDate());
            helper.setText(text, true);

        }catch (MessagingException e){
            throw new RuntimeException(e);
        }
        return mimeMessage;
    }
}
