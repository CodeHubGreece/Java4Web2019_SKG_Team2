package org.regeneration.efkajpa.controller;

import java.util.List;

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
	private DoctorRepository doctorRepository;
	
	@GetMapping("/doctors/get/{id}")
	public Doctor getDoctorById(@PathVariable("id") int id) {
		return doctorRepository.retrieve(id);
	}
	
	@GetMapping("/doctors/getAll")
	//Returning is List is supported with JSON response
	public List<Doctors> getAllDoctors() {
		return doctorRepository.getAll();
	}

	@PostMapping("/doctor/create")
	public Doctors createDoctor(@RequestBody Doctors doctor) {
		doctorRepository.store(doctor);
		return doctor;
	}
	
	@GetMapping("/doctor/search/{name}")
	public Doctors getDoctorByName(@PathVariable("name") String name) {
		return doctorRepository.search(name);
	}
	
	@DeleteMapping("/doctor/delete/{id}")
	public Doctors deleteDoctorById(@PathVariable("id") int id) {
		return doctorRepository.delete(id);
	}
}