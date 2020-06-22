package com.learning.springAop.controller;

import com.learning.springAop.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class Controller {

    @Autowired
    private BusinessService businessService;


    @GetMapping("/test")
    public String  testTracker(){
        String name=businessService.print("manoj");
        return name;
    }
}
