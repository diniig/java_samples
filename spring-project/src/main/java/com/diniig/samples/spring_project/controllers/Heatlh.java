package com.diniig.samples.spring_project.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Heatlh {

    @RequestMapping(path = "/health")
    public ResponseEntity<String> health(){
        return ResponseEntity.ok("ok");
    }

    @RequestMapping(path = "/ready")
    public ResponseEntity<String> ready(){
        return ResponseEntity.ok("ok");
    }
}
