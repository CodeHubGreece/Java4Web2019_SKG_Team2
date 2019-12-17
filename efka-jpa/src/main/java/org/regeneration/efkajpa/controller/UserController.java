package org.regeneration.efkajpa.controller;


import org.regeneration.efkajpa.entity.Users;
import org.regeneration.efkajpa.repository.CitizenRepository;
import org.regeneration.efkajpa.security.ApiUserDetails;
import org.regeneration.efkajpa.security.ApiUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private CitizenRepository citizenRepository;

    @Autowired
    private ApiUserDetailsService apiUserDetailsService;

//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping("/login")
//    public ApiUserDetails getUsers(@RequestBody UserDetails userDetails) {
//        /*@RequestParam(value = "username", required = true) String username, @RequestParam(value = "password", required = true) String password) {*/
//        return apiUserDetailsService.loadUserByUsername(userDetails.getUsername());
//    }

}

