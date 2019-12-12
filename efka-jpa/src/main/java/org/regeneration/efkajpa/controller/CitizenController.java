//package org.regeneration.efkajpa.controller;
//
//import java.util.List;
//
//import org.regeneration.efkajpa.entity.Citizens;
//import org.regeneration.efkajpa.service.CitizenService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import org.regeneration.efkajpa.entity.Citizens;
//import org.regeneration.efkajpa.repository.CitizenRepository;
//
//@RestController
//public class CitizenController {
//
//	@Autowired
//	private CitizenService citizenService;
//
//	@GetMapping("/citizen/get/{id}")
//	public Citizens getCitizenByAmka(@PathVariable("id") String amka) {
//		return citizenService.retrieve(amka);
//	}
//
//	/*@GetMapping("/citizen/getAll")
//	//Returning is List is supported with JSON response
//	public List<Citizens> getAllCitizens() {
//		return citizenRepository.getAll();
//	}
//
//	@PostMapping("/citizen/create")
//	public Citizens createCitizen(@RequestBody Citizens citizens) {
//		citizenRepository.store(citizens);
//		return citizens;
//	}
//
//	@GetMapping("/citizen/search/{name}")
//	public Citizens getCitizenByName(@PathVariable("name") String name) {
//		return citizenRepository.search(name);
//	}
//
//	@DeleteMapping("/citizen/delete/{id}")
//	public Citizens deleteCitizenById(@PathVariable("id") int id) {
//		return citizenRepository.delete(id);
//	}*/
//}