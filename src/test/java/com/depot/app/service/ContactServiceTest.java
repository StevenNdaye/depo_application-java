package com.depot.app.service;

import com.depot.app.model.Feedback;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by steven on 2014/08/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/test-application-context.xml")
@Transactional
@TransactionConfiguration
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ContactServiceTest {

    @Autowired private ContactService contactService;
    private Date date = new Date();

    @Test
    public void itShouldSaveAndGetFeedback(){
        contactService.saveFeedback(createFeedback());
        Feedback feedback = contactService.getFeedback(1);

        assertThat(feedback.getId(), is(1L));
        assertThat(feedback.getDate(), is(date));
        assertThat(feedback.getEmail(), is("email@email.com"));
        assertThat(feedback.getComments(), is("Our new comments"));
        assertThat(feedback.getFullName(), is("Full Name"));

    }

    private Feedback createFeedback() {
        Feedback feedback = new Feedback();

        feedback.setDate(date);
        feedback.setEmail("email@email.com");
        feedback.setComments("Our new comments");
        feedback.setFullName("Full Name");

        return feedback;
    }

}
