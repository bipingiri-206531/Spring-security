package com.practice2.practice2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class HomeController {

    @GetMapping("welcome")
    public String publicUrl() {
        return "Welcome to PUBLIC page";
    }

    @GetMapping("/read")
    public String readAuthority() {
        return "Read authority";
    }
}
