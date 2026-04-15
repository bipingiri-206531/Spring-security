package com.practice2.practice2.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/himal")
public class HimalController {

    @GetMapping("/welcome")
    public String bipinUrl(){
        return "Welcome to himal page";
    }
}
