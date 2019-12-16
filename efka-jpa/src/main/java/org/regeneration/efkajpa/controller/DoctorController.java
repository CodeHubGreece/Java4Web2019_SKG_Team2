package org.regeneration.efkajpa.controller;

import java.util.List;

import org.regeneration.efkajpa.entity.Specialties;
import org.regeneration.efkajpa.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.regeneration.efkajpa.entity.Doctors;

@RestController
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@CrossOrigin(origins = "http://localhost:63342")
	@GetMapping("/get_specialty/{specialtyId}")
	public List<Doctors> getDoctorsBySpecialty(@PathVariable Specialties specialtyId) {
		return doctorService.retrieveBySpecialty(specialtyId);
	}

	@GetMapping("/doctors/all")
	public List<Doctors> findAll() {
		return doctorService.findAll();
	}

}