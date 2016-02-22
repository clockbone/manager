package com.clockbone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by qinjun on 2016/2/5.
 */
@Controller
@RequestMapping("/user")
public class LoginController {
    @RequestMapping("/login")
    public String index1(){
        return "login";
    }

    @RequestMapping("/denied")
    public String denied(){
        return "denied";
    }


}
