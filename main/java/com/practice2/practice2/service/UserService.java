package com.practice2.practice2.service;

import com.practice2.practice2.entity.User;
import com.practice2.practice2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "User deleted successfully";
    }
}