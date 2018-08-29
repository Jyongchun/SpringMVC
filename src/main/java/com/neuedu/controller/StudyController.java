package com.neuedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudyController {
    @RequestMapping(value = "/hello")
    public String hello(){
        //前缀+返回值+后缀=url
        return "hello";
    }
}

