package com.hmsystem.controller;

import com.hmsystem.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RequestHttpStarController {

    @Value("${username}")
    private String uname;

    @Value("${address[0]}")
    private String addressT;

    @Autowired
    private Person person;

    @ResponseBody
    @RequestMapping("/indexString")
    public String requestString(){
        System.out.println(addressT);
        System.out.println(person);
        return uname + " Welcome to Java World!";
    }

    @RequestMapping("/index")
    public ModelAndView requestH(){
        System.out.println("Spring boot開始しました。");
        ModelAndView modelAndView = new ModelAndView("index"); //设置对应得jsp(index)模板
        modelAndView.addObject("name","yaliu");
        return modelAndView;
    }
}
