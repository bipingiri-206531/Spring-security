package com.practice2.practice2.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dipak")
public class DipakController {

    @GetMapping("/welcome")
    public String dipakUrl() {
        return "Welcome to PUBLIC page";
    }

    @GetMapping("/read")
        public String readAuthority(){
            return "Read authority";
        }
}
