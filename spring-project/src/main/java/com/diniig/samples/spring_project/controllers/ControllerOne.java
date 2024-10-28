package com.diniig.samples.spring_project.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerOne {

    @RequestMapping(path = "/one-one")
    public ResponseEntity<String> methodOne(){
        return ResponseEntity.ok("Hello world");
    }
    
}
