package org.regeneration.efkajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.regeneration.efkajpa.entity.Citizen;
import org.regeneration.efkajpa.repository.CitizenRepository;

@RestController
public class CitizenController {

	@Autowired
	private CitizenRepository citizenRepository;
	
	@GetMapping("/citizen/get/{id}")
	public Citizen getCitizenById(@PathVariable("id") Long id) {
		return citizenRepository.retrieve(id);
	}
	
	@GetMapping("/citizen/getAll")
	//Returning is List is supported with JSON response
	public List<Citizen> getAllCitizens() {
		return citizenRepository.getAll();
	}

	@PostMapping("/citizen/create")
	public Citizen createCitizen(@RequestBody Citizen citizen) {
		citizenRepository.store(citizen);
		return citizen;
	}
	
	@GetMapping("/citizen/search/{name}")
	public Citizen getCitizenByName(@PathVariable("name") String name) {
		return citizenRepository.search(name);
	}
	
	@DeleteMapping("/citizen/delete/{id}")
	public Citizen deleteCitizenById(@PathVariable("id") int id) {
		return citizenRepository.delete(id);
	}
}