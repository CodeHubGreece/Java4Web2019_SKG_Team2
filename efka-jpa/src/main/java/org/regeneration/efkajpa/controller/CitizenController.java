package org.regeneration.efkajpa.controller;

import java.util.List;

import org.regeneration.efkajpa.Registration;
import org.regeneration.efkajpa.entity.Citizens;
import org.regeneration.efkajpa.service.CitizenService;
import org.regeneration.efkajpa.service.NewUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.NameAlreadyBoundException;

@RestController
public class CitizenController {

	@Autowired
	private NewUserService newUserService;

	@Autowired
	public CitizenService citizenService;

	@GetMapping("/citizen/get/{id}")
	public Citizens getCitizenByAmka(@PathVariable("id") String amka) {
		return citizenService.retrieveByAmka(amka);
	}

    @PostMapping("/register")
	public void createUsers(@RequestBody Registration registration) throws NameAlreadyBoundException {
		newUserService.store(registration.getAmka(), registration.getLastName(), registration.getFirstName(), registration.getEmail(), registration.getUsername(),
				registration.getPassword(), registration.getPhone(), registration.getUserType());
    }

}