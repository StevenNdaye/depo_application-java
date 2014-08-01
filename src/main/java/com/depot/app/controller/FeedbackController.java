package com.depot.app.controller;

import net.tanesha.recaptcha.ReCaptcha;
import net.tanesha.recaptcha.ReCaptchaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletRequest;

@Controller
public class FeedbackController {

    public static final String CLASS = "class";
    public static final String MESSAGE = "message";
    public static final String VALID_MESSAGE = "You feedback has reached successfully!!Thank you, we will contact you soon";
    public static final String BG_SUCCESS = "bg-success";
    public static final String INVALID_MESSAGE = "You are quite human, try again!";
    public static final String BG_DANGER = "bg-danger";
    public static final String CONTACT_FORM = "contactForm";

    @Autowired
    private ReCaptcha reCaptcha;

    @RequestMapping(value = "/contactus", method = RequestMethod.GET)
    public String contactUs(){
        return CONTACT_FORM;
    }

    @RequestMapping(value = "/submitContactForm", method = RequestMethod.POST)
    public String submitContactForm(@RequestParam("recaptcha_challenge_field") String challengeField,
                            @RequestParam("recaptcha_response_field") String responseField, ServletRequest servletRequest, ModelMap modelMap) {
        String remoteAddress = servletRequest.getRemoteAddr();
        ReCaptchaResponse reCaptchaResponse = this.reCaptcha.checkAnswer(remoteAddress, challengeField, responseField);

        if(reCaptchaResponse.isValid()){
            modelMap.addAttribute(MESSAGE, VALID_MESSAGE);
            modelMap.addAttribute(CLASS, BG_SUCCESS);
        }else{
            modelMap.addAttribute(MESSAGE, INVALID_MESSAGE);
            modelMap.addAttribute(CLASS, BG_DANGER);
        }

        return CONTACT_FORM;
    }
}
