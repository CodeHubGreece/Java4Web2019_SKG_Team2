package org.regeneration.efkajpa.controller;

import java.util.List;
import java.util.Set;

import org.regeneration.efkajpa.entity.Appointments;
import org.regeneration.efkajpa.entity.Specialties;
import org.regeneration.efkajpa.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.regeneration.efkajpa.entity.Doctors;
import org.regeneration.efkajpa.repository.DoctorRepository;

@RestController
public class DoctorController {

	@Autowired
	private DoctorService doctorService;

	@GetMapping("/doctors/specialty/{specialty}")
	public Set<Doctors> getDoctorsBySpecialty(@PathVariable Specialties specialty) {
		return doctorService.retrieveBySpecialty(specialty);
	}

}