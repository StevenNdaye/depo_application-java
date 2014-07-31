package com.depot.app.controller;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FeedbackControllerTest {

    private FeedbackController feedbackController;
    @Before
    public void setUp(){
        feedbackController = new FeedbackController();
    }
    @Test
    public void itShouldDisplayContactForm(){
        String viewName = feedbackController.contactUs();
        assertThat(viewName, is("contactForm"));
    }
}
