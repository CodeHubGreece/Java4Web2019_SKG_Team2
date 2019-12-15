//package org.regeneration.efkajpa.controller;
//
//
//import org.regeneration.efkajpa.entity.Users;
//import org.regeneration.efkajpa.repository.CitizenRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Arrays;
//import java.util.List;
//
//@RestController
//public class UserController {
//    @Autowired
//    private CitizenRepository citizenRepository;
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/users")
//    public List<Users> getUsers(@RequestParam(value = "username", required = true) String username) {
//        Users user = new Users(username, "1234", 'd');
//        return Arrays.asList(user);
//    }
//
//    /*@GetMapping("/users/get/{username}")
//    public Users getUsersByUsername(@PathVariable String username) {
//        return newUserService.retrieve(username);
//    }*/
//
//    @PostMapping("/users/create")
//    public void createUsers(@RequestBody Users user) {
//        userService.store(user);
//    }
//
//   /* @GetMapping("/users/getAll")
//    //Returning is List is supported with JSON response
//    public List<Citizens> getAllCitizens() {
//        return usersRepository.getAll();
//    }
//
//    @GetMapping("/citizen/search/{name}")
//    public Users getUsersByName(@PathVariable("name") String name) {
//        return UsersRepository.search(name);
//    }*/
//
//
//}
//
