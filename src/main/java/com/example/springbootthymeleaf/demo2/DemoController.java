package com.example.springbootthymeleaf.demo2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DemoController {
    
    @RequestMapping("hello")
    public String hello(HttpServletRequest request, @RequestParam(value = "name", defaultValue = "springboot-thymeleaf") String name){
        request.setAttribute("name", name);
        return "hello";
    }
    
}
