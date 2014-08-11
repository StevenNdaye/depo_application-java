package com.depot.app.controller;

import com.depot.app.model.Feedback;
import com.depot.app.service.EmailService;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;
import net.tanesha.recaptcha.http.HttpLoader;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import javax.servlet.ServletRequest;
import java.util.HashMap;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FeedbackControllerTest {

    private FeedbackController feedbackController;
    private ReCaptchaImpl reCaptcha;
    private MockHttpLoader mockHttpLoader;


    @Before
    public void setUp(){
        feedbackController = new FeedbackController();
        reCaptcha = new ReCaptchaImpl();
        mockHttpLoader = new MockHttpLoader();

        reCaptcha.setIncludeNoscript(false);
        reCaptcha.setPrivateKey("testing");
        reCaptcha.setPublicKey("testing");
        reCaptcha.setRecaptchaServer(ReCaptchaImpl.HTTP_SERVER);
        reCaptcha.setHttpLoader(mockHttpLoader);
    }
    @Test
    public void itShouldDisplayContactForm(){
        String viewName = feedbackController.contactUs(new ModelMap());
        assertThat(viewName, is("contactForm"));
    }

    @Test
    public void itShouldCreateCaptchaHtml() {

        String html = reCaptcha.createRecaptchaHtml(null, null);
        assertTrue(html.indexOf("<script") != -1);

        reCaptcha.setIncludeNoscript(true);

        assertTrue(reCaptcha.createRecaptchaHtml(null, null).indexOf("<noscript>") != -1);


        String html2 = reCaptcha.createRecaptchaHtml("The Error", null);
        assertTrue(html2.indexOf("&amp;error=The+Error") != -1);

        Properties options = new Properties();
        options.setProperty("theme", "mytheme");
        options.setProperty("tabindex", "1");
        String html3 = reCaptcha.createRecaptchaHtml("The Error", options);
        assertTrue(html3.indexOf("theme:'mytheme'") != -1);
        assertTrue(html3.indexOf("tabindex:'1'") != -1);
        assertTrue(html3.indexOf(",") != -1);


        // check the shortcut
        String html4 = reCaptcha.createRecaptchaHtml("Some Error", "othertheme", new Integer(3));
        assertTrue(html4.indexOf("theme:'othertheme'") != -1);
        assertTrue(html4.indexOf("tabindex:'3'") != -1);
        assertTrue(html4.indexOf(",") != -1);

    }

    @Test
    public void itShouldIntegrateWithReCaptchaService(){

        mockHttpLoader.setNextReply("true\n");

        ReCaptchaResponse checkAnswer = reCaptcha.checkAnswer("123.123.123.123", "abcdefghijklmnop", "response");

        assertTrue(checkAnswer.isValid());
        assertEquals(null, checkAnswer.getErrorMessage());
    }


    public class MockHttpLoader implements HttpLoader {
        private String reply;

        public void setNextReply(String reply){
            this.reply = reply;
        }

        @Override
        public String httpPost(String url, String postData) {
            return reply;
        }

        @Override
        public String httpGet(String url) {
            return reply;
        }
    }
}
