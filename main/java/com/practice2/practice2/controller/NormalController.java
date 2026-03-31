package com.practice2.practice2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/normal")
@RequestMapping()
public class NormalController {

    @GetMapping("/welcome")
    public String normalUrl() {
        return "Welcome to NORMAL page";
    }
}
