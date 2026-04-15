package com.practice2.practice2.config;


import com.practice2.practice2.entity.CustomUserDetails;
import com.practice2.practice2.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.practice2.practice2.entity.User;import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    Logger log = (Logger) LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserRepository userRepository;


    static Map<String, User> userMap = new HashMap<>();


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(userMap.containsKey(username)) {
            log.info("User found in cache {}",username);
            return new CustomUserDetails(userMap.get(username));
        }else {
            log.info("User not found in cache {}",username);
            User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
            log.info("Loading user in cache {}", username);
            userMap.put(username,user);
            return new CustomUserDetails(user);
        }
    }
}
