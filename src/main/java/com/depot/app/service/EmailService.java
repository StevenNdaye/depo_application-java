package com.depot.app.service;

import com.depot.app.model.Feedback;

/**
 * Created by steven on 2014/08/01.
 */
public interface EmailService {
    public void send(Feedback feedback);
}
