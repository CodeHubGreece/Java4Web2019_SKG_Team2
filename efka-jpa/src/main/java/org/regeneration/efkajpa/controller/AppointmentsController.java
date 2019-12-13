package org.regeneration.efkajpa.controller;

import org.regeneration.efkajpa.service.AppointmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.regeneration.efkajpa.entity.Appointments;

@RestController
public class AppointmentsController {


	@Autowired
	private AppointmentsService appointmentsService;


	@GetMapping("/appointments/{id}")
	public Appointments getAppointmentsById(@PathVariable Long id) {
		return appointmentsService.findAppointmentById(id);
	}

	@DeleteMapping("/delete_appointments/{id}")
	public void deleteAppointments (@PathVariable Long id) {
			appointmentsService.deleteAppointments(id);
	}

	@PutMapping("/update_appointments/{id}")
	public void updateAppointmentsById(@PathVariable Long id, @RequestBody Appointments updatedAppointments) {
		appointmentsService.updateAppointmentsById(id);
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