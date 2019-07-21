package com.test.reglog.controller;




import com.test.reglog.dao.RegisterService;
import com.test.reglog.dao.UserService;
import com.test.reglog.mainDo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


@RestController
public class TestApp {


    @Autowired
    private UserService userService;

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "/register.html", method = RequestMethod.GET)
    public ModelAndView register(){
        return new ModelAndView("register");
    }

    @RequestMapping(value = "/login.html", method = RequestMethod.GET)
    public ModelAndView login(){

        return new ModelAndView("login");
    }

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView index(){

        return new ModelAndView("index");
    }

    @ResponseBody
    @RequestMapping("/public/register")
    public Object register(User formuser){

//        System.out.println("开始注册！");
//        System.out.println(formuser.getUsername());
//        System.out.println(formuser.getPassword());
//        System.out.println(formuser.getNickname());
        Map<String, Object> result = registerService.register(formuser);
        return  result;
    }

    @ResponseBody
    @RequestMapping("/public/login")
    public Object login(String username,String password) {
        return userService.login(username,password);
    }

}
