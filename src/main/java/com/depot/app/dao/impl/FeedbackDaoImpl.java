package com.depot.app.dao.impl;

import com.depot.app.dao.FeedbackDao;
import com.depot.app.model.Feedback;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by steven on 2014/08/08.
 */
@Repository
public class FeedbackDaoImpl implements FeedbackDao{

    @Autowired private SessionFactory sessionFactory;

    @Override
    public void create(Feedback feedback) {
        this.sessionFactory.getCurrentSession().save(feedback);
    }
}
