package org.regeneration.efkajpa.controller;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.regeneration.efkajpa.NewAppointment;
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
	public void createAppointments(@RequestBody NewAppointment newAppointment) throws ParseException {
		Date newDate = new SimpleDateFormat("dd-MM-yyyy").parse(newAppointment.getDate());
		java.sql.Date sqlDate = new java.sql.Date(newDate.getTime());
		appointmentsService.createAppointment(newAppointment.getAmkaC(), newAppointment.getDoctorId(), sqlDate, newAppointment.getTime(),
				newAppointment.getIllnessDescription(), newAppointment.getComments());
	}

	@DeleteMapping("/appointments/delete/{id}")
	public void deleteAppointments (@PathVariable Long id) {
			appointmentsService.deleteAppointments(id);
	}

	@PutMapping("/appointments/update/{id}")
	public void updateAppointmentsById(@PathVariable Long id, @RequestBody NewAppointment updatedAppointment) throws ParseException {
		Date newDate = new SimpleDateFormat("dd-MM-yyyy").parse(updatedAppointment.getDate());
		java.sql.Date sqlDate = new java.sql.Date(newDate.getTime());
		appointmentsService.updateAppointment(id, sqlDate, updatedAppointment.getTime());
	}

}
