//package com.practice2.practice2.config;
//
//import org.jspecify.annotations.Nullable;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CustomAuthenticationProvider  implements AuthenticationProvider {
//
//    @Autowired
//    private CustomUserDetailsService customUserDetailsService;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();
//        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
//        if (passwordEncoder.matches(authentication.getCredentials().toString(), userDetails.getPassword())) {
//            return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
//        }
//        throw new BadCredentialsException("Invalid username or password");
//}
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return true;
//    }
//}
