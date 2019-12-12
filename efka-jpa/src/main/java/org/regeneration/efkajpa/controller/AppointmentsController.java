package org.regeneration.efkajpa.controller;

import java.util.List;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.regeneration.efkajpa.entity.Appointments;
import org.regeneration.efkajpa.repository.AppointmentsRepository;

@RestController
public class AppointmentsController {

	@Autowired
	private AppointmentsRepository appointmentsRepository;

	@GetMapping("/appointments/{id}")
	public Appointments getAppointmentsById(@PathVariable Long id) {
		return appointmentsRepository.findById(id).get();
	}

	/*@GetMapping("/appointments/{id}")
	public Appointments getAppointmentsById(@PathVariable("id") Long id) {
		return appointmentsRepository.retrieve(id);
	}

	@GetMapping("/appointments/getAll")
	//Returning is List is supported with JSON response
	public List<Appointments> getAllAppointments() {
		return appointmentsRepository.getAll();
	}

	@PostMapping("/appointments/create")
	public Appointments createAppointments(@RequestBody Appointments appointments) {
		appointmentsRepository.store(appointments);
		return appointments;
	}

	@GetMapping("/appointments/search/{date}")
	public Appointments getAppointmentsByName(@PathVariable("date") Date date) {
		return appointmentsRepository.search(date);
	}

	@DeleteMapping("/appointments/delete/{id}")
	public Appointments deleteAppointmentsById(@PathVariable("id") int id) {
		return appointmentsRepository.delete(id);
	}*/
}