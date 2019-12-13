package org.regeneration.efkajpa.controller;

import java.util.List;

import org.regeneration.efkajpa.Registration;
import org.regeneration.efkajpa.entity.Citizens;
import org.regeneration.efkajpa.service.NewUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.regeneration.efkajpa.entity.Citizens;
import org.regeneration.efkajpa.repository.CitizenRepository;

@RestController
public class CitizenController {

//	@Autowired
//	private CitizenService citizenService;

	@Autowired
	private NewUserService newUserService;

//	@GetMapping("/citizen/get/{id}")
//	public Citizens getCitizenByAmka(@PathVariable("id") String amka) {
//		return citizenService.retrieveByAmka(amka);
//	}

	/*@RequestParam(value = "amka", required = true) String amka, @RequestParam(value = "lastName", required = true) String lastName,
							@RequestParam(value = "firstName", required = true) String firstName, @RequestParam(value = "email", required = true) String email,
							@RequestParam(value = "username", required = true) String username, @RequestParam(value = "password", required = true) String password,
							@RequestParam(value = "phone", required = true) String phone) {*/

    @PostMapping("/register")
	public void createUsers(@RequestBody Registration registration){
		newUserService.store(registration.getAmka(), registration.getLastName(), registration.getFirstName(), registration.getEmail(), registration.getUsername(),
				registration.getPassword(), registration.getPhone(), registration.getType());
    }

	/*@GetMapping("/citizen/getAll")
	//Returning is List is supported with JSON response
	public List<Citizens> getAllCitizens() {
		return citizenRepository.getAll();
	}

	@PostMapping("/citizen/create")
	public Citizens createCitizen(@RequestBody Citizens citizens) {
		citizenRepository.store(citizens);
		return citizens;
	}

	@GetMapping("/citizen/search/{name}")
	public Citizens getCitizenByName(@PathVariable("name") String name) {
		return citizenRepository.search(name);
	}

	@DeleteMapping("/citizen/delete/{id}")
	public Citizens deleteCitizenById(@PathVariable("id") int id) {
		return citizenRepository.delete(id);
	}*/
}