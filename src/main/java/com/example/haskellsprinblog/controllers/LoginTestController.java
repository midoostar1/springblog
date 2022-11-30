package com.example.haskellsprinblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginTestController {

    @GetMapping("/loginForms")
    public String login(){
return "loginForms";
    }
}
