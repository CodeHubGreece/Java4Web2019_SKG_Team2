package org.regeneration.efkajpa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

	@GetMapping("/appointments/search/date")
	public List<Appointments> getAppointmentsByDate(@RequestParam(value = "fromDate", required = true) String fromDate,
													@RequestParam(value = "toDate", required = true) String toDate) throws ParseException {
		Date newFromDate = new SimpleDateFormat("dd-MM-yyyy").parse(fromDate);
		java.sql.Date sqlFromDate = new java.sql.Date(newFromDate.getTime());
		Date newToDate = new SimpleDateFormat("dd-MM-yyyy").parse(toDate);
		java.sql.Date sqlToDate = new java.sql.Date(newToDate.getTime());
		return appointmentsService.searchAppointments(sqlFromDate, sqlToDate);
	}

	@GetMapping("/appointments/search/illness")
	public List<Appointments> getAppointmentsByIllness(@RequestParam(value = "illnessDescription", required = true) String illnessDescription) throws ParseException {
		return appointmentsService.searchAppointments(illnessDescription);
	}

	@GetMapping("/appointments/search/date&illness")
	public List<Appointments> getAppointmentsByDateAndIllness(@RequestParam(value = "fromDate", required = true) String fromDate,
													@RequestParam(value = "toDate", required = true) String toDate,
													@RequestParam(value = "illnessDescription", required = true) String illnessDescription) throws ParseException {
		Date newFromDate = new SimpleDateFormat("dd-MM-yyyy").parse(fromDate);
		java.sql.Date sqlFromDate = new java.sql.Date(newFromDate.getTime());
		Date newToDate = new SimpleDateFormat("dd-MM-yyyy").parse(toDate);
		java.sql.Date sqlToDate = new java.sql.Date(newToDate.getTime());
		return appointmentsService.searchAppointments(sqlFromDate, sqlToDate, illnessDescription);
	}

}
