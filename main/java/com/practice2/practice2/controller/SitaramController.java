package com.practice2.practice2.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sitaram")
public class SitaramController {

    @RequestMapping("/welcome")
    public String SitaramUrl() {
        return "Welcome to Sitaram page";
    }
}
