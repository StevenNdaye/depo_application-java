package com.depot.app.service.impl;

import com.depot.app.dao.FeedbackDao;
import com.depot.app.model.Feedback;
import com.depot.app.service.ContactService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

/**
 * Created by steven on 2014/08/08.
 */
@Service
@Transactional(
        propagation = Propagation.REQUIRED,
        isolation = Isolation.DEFAULT,
        readOnly = false)
public class ContactServiceImpl implements ContactService {

    @Inject private FeedbackDao feedbackDao;

    @Override
    public void saveFeedback(Feedback feedback) {
        feedbackDao.create(feedback);
    }

    @Override
    public Feedback getFeedback(Integer id) {
        return feedbackDao.getFeedback(id);
    }
}
