package org.regeneration.efkajpa.controller;


import org.regeneration.efkajpa.entity.Citizens;
import org.regeneration.efkajpa.entity.Users;
import org.regeneration.efkajpa.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/users/get/{id}")
    public Citizens getCitizenByUserId(@PathVariable("id") Long id) {
        return UsersRepository.retrieve(id);
    }

    @GetMapping("/users/getAll")
    //Returning is List is supported with JSON response
    public List<Citizens> getAllCitizens() {
        return usersRepository.getAll();
    }

    @PostMapping("/users/create")
    public Users createUsers(@RequestBody Users user) {
        usersRepository.store(user);
        return user;
    }

    @GetMapping("/citizen/search/{name}")
    public Users getUsersByName(@PathVariable("name") String name) {
        return UsersRepository.search(name);
    }


}

