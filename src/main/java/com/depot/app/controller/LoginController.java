package com.depot.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "loginPage";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(){
        return "welcomePage";
    }

    @RequestMapping(value = "/loginError", method = RequestMethod.GET)
    public String loginError(ModelMap modelMap){
        modelMap.addAttribute("error", true);
        return "loginPage";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(){
        return "login";
    }
}
