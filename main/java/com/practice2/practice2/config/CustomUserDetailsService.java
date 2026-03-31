package com.practice2.practice2.config;

import com.practice2.practice2.model.entity.CustomUserDetails;
import com.practice2.practice2.model.entity.User;
import com.practice2.practice2.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;


import java.util.HashMap;
import java.util.Map;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
    @Autowired
    private UserRepository userRepository;

    static Map<String, User> userMap = new HashMap<>();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(userMap.containsKey(username)) {
            logger.info("User found in cache {}");
            return new CustomUserDetails(userMap.get(username));
        }else {
            logger.info("User not found in cache{}");
            User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
            logger.info("Loading user in cache {}");
            userMap.put(username,user);
            return new CustomUserDetails(userMap.get(username));
        }
    }
}
