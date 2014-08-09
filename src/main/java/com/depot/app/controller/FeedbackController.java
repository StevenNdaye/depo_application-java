package com.depot.app.controller;

import com.depot.app.model.Feedback;
import com.depot.app.service.ContactService;
import com.depot.app.service.EmailService;
import net.tanesha.recaptcha.ReCaptcha;
import net.tanesha.recaptcha.ReCaptchaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/contact")
public class FeedbackController {

    public static final String CLASS = "class";
    public static final String MESSAGE = "message";
    public static final String VALID_MESSAGE = "Your feedback has reached us successfully!!Thank you, we will contact you soon";
    public static final String BG_SUCCESS = "bg-success";
    public static final String INVALID_MESSAGE = "Your feedback did not reach us! Try again!";
    public static final String BG_DANGER = "bg-danger";
    public static final String CONTACT_FORM = "contactForm";
    public static final String FEEDBACK_KEY = "feedback";
    public static final String THANKS_FORM = "thanksForm";

    @Autowired
    private ReCaptcha reCaptcha;
    @Autowired
    private EmailService emailService;
    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String contactUs(ModelMap modelMap){
        prepareFormForInput(modelMap);
        return CONTACT_FORM;
    }


    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submitContactForm(@RequestParam("recaptcha_challenge_field") String challengeField,
                            @RequestParam("recaptcha_response_field") String responseField,
                            @ModelAttribute(value = FEEDBACK_KEY) Feedback feedback,
                            ServletRequest servletRequest, ModelMap modelMap, BindingResult result) {
        if (result.hasErrors()){
            result.reject("error.global");
            return CONTACT_FORM;
        }

        handleCreationDate(feedback);
        handleReCaptcha(challengeField, responseField, servletRequest, modelMap, feedback);
        prepareFormForInput(modelMap);
        return "redirect:/contact/thank";
    }

    @RequestMapping(value = "/thank", method = RequestMethod.GET)
    public String getThankPage(ModelMap modelMap){

        return THANKS_FORM;
    }

    private void handleCreationDate(Feedback feedback) {
        feedback.setDate(new Date());
    }

    private boolean handleReCaptcha(String challengeField, String responseField, ServletRequest servletRequest, ModelMap modelMap, Feedback feedback) {
        String remoteAddress = servletRequest.getRemoteAddr();
        ReCaptchaResponse reCaptchaResponse = this.reCaptcha.checkAnswer(remoteAddress, challengeField, responseField);

        if(reCaptchaResponse.isValid()){
            sendEmail(feedback);
            saveFeedback(feedback);
            return validCaptcha(modelMap);
        }else{
            return invalidCaptcha(modelMap);
        }
    }

    private void saveFeedback(Feedback feedback) {
        contactService.saveFeedback(feedback);
    }

    private void sendEmail(Feedback feedback) {
        emailService.send(feedback);
    }

    private boolean invalidCaptcha(ModelMap modelMap) {
        modelMap.addAttribute(MESSAGE, INVALID_MESSAGE);
        modelMap.addAttribute(CLASS, BG_DANGER);
        return false;
    }

    private boolean validCaptcha(ModelMap modelMap) {
        modelMap.addAttribute(MESSAGE, VALID_MESSAGE);
        modelMap.addAttribute(CLASS, BG_SUCCESS);
        return true;
    }

    private void prepareFormForInput(ModelMap modelMap) {
        modelMap.addAttribute(FEEDBACK_KEY, new Feedback());
    }
}
