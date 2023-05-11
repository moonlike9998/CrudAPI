package com.example.demo.controllers;

import com.example.demo.Service.LoginService;
import com.example.demo.model.LoginModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class LoginController {

    @RequestMapping(value = "/Login", method = RequestMethod.GET)
    public String getLogin() {
        return "login";
    }

    @RequestMapping (value = "/Login", method = RequestMethod.POST)
    public ModelAndView postLogin(@ModelAttribute LoginModel model) {
        ModelAndView mv = new ModelAndView("profile");
        mv.addObject("loginModel",model);
        return mv;
    }

}
