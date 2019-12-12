package org.regeneration.efkajpa.controller;

import java.util.List;
import java.util.Set;

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

	@GetMapping("/doctors/get/{specialty}")
	public Set<Doctors> getDoctorBySpecialty(@PathVariable Specialties specialty) {
		return doctorService.retrieve(specialty);
	}

	/*@GetMapping("/doctors/getAll")
	//Returning is List is supported with JSON response
	public List<Doctors> getAllDoctors() {
		return doctorRepository.getAll();
	}

	@PostMapping("/doctor/create")
	public Doctors createDoctor(@RequestBody Doctors doctors) {
		doctorRepository.store(doctors);
		return doctors;
	}

	@GetMapping("/doctor/search/{name}")
	public Doctors getDoctorByName(@PathVariable("name") String name) {
		return doctorRepository.search(name);
	}

	@DeleteMapping("/doctor/delete/{id}")
	public Doctors deleteDoctorById(@PathVariable("id") int id) {
		return doctorRepository.delete(id);
	}*/
}