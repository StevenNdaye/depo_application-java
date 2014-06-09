package com.depot.app.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LoginControllerTest{

    LoginController loginController;
    @Before
    public void setUp(){
        loginController = new LoginController();
    }

    @Test
    public void itShouldReturnLoginView(){
        String viewName = loginController.login();
        assertThat(viewName, is("loginPage"));
    }

    @Test
    public void itShouldReturnWelcomeView(){
        String welcomeViewName = loginController.welcome();
        assertThat(welcomeViewName, is("welcomePage"));
    }

    @Test
    public void itShouldReturnLoginPageWithErrors(){
        ModelMap map = new ModelMap();
        String error = loginController.loginError(map);
        assertThat((Boolean) map.get("error"), is(true));
        assertThat(error, is("loginPage"));
    }

    @Test
    public void itShouldLogoutAndReturnToLoginPage(){
        assertThat(loginController.logout(), is("redirect:/"));
    }

}
