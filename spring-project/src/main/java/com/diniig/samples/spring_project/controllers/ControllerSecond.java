package com.diniig.samples.spring_project.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerSecond {

    @RequestMapping(path = "/second-one")
    public String methodOne(){
        return "Hello world 2";
    }
}
