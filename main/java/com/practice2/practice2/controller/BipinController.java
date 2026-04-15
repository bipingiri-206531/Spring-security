package com.practice2.practice2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bipin")
public class BipinController {

    @GetMapping("/read")
    public String readAuthority() {
        return "Read authority";
    }

    @GetMapping("/write")
    public String writeAuthority() {
        return "Write authority";
    }
}
