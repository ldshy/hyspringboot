package com.example.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value="login")
@Controller
public class LoginController {

    @RequestMapping(value="/login")
    public String login(){
        return "login/login";
    }
}
