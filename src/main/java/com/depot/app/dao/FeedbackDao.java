package com.depot.app.dao;

import com.depot.app.model.Feedback;

/**
 * Created by steven on 2014/08/08.
 */
public interface FeedbackDao{
    public void create(Feedback feedback);
    Feedback getFeedback(Integer id);
}
