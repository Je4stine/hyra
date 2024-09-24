package com.jsoftware.theoffice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ClockInOutController {

    @GetMapping("/")
    public String greet(){
        return "Hello";
    }


}
