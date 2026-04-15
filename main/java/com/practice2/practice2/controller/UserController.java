package com.practice2.practice2.controller;

import com.practice2.practice2.entity.User;
import com.practice2.practice2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping("/save")
    public User create(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.saveUser(user);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
