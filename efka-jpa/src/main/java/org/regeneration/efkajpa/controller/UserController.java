package org.regeneration.efkajpa.controller;


import org.regeneration.efkajpa.UserInfo;
import org.regeneration.efkajpa.repository.CitizenRepository;
import org.regeneration.efkajpa.security.ApiUserDetailsService;
import org.regeneration.efkajpa.service.NewUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
public class UserController {
    @Autowired
    private CitizenRepository citizenRepository;

    @Autowired
    private ApiUserDetailsService apiUserDetailsService;

    @Autowired
    private NewUserService newUserService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/user")
    public UserInfo getUsers(Principal  user) {
        return apiUserDetailsService.getUserByUsername(user.getName());
    }

    @PutMapping("/pass")
    public void encodePasswords(){
        newUserService.updatePass();
    }

}

