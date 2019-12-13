package org.regeneration.efkajpa.controller;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	@PostMapping("/appointments/create")
	public void createAppointments//(@RequestBody Appointments appointments)
	(@RequestParam(value = "amkaC", required = true) String amkaC, @RequestParam(value = "doctorId", required = true) String doctorId,
	@RequestParam(value = "date", required = true) String date, @RequestParam(value = "time", required = true) Time time,
	@RequestParam(value = "illnessDescription", required = true) String illnessDescription, @RequestParam(value = "comments", required = true) String comments) throws ParseException {
		Date newDate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
		java.sql.Date sqlDate = new java.sql.Date(newDate.getTime());
		appointmentsService.createAppointment(amkaC, doctorId, sqlDate, time, illnessDescription, comments);
	}

	@DeleteMapping("/appointments/delete/{id}")
	public void deleteAppointments (@PathVariable Long id) {
			appointmentsService.deleteAppointments(id);
	}

//	@PutMapping("/update_appointments/{id}")
//	public void updateAppointmentsById(@PathVariable Long id, @RequestBody Appointments updatedAppointments) {
//		appointmentsService.updateAppointmentsById(id);
//	}

}
