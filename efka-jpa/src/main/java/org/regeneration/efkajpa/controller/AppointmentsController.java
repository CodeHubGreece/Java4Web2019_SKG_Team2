package org.regeneration.efkajpa.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.regeneration.efkajpa.NewAppointment;
import org.regeneration.efkajpa.entity.Specialties;
import org.regeneration.efkajpa.service.AppointmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
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

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/appointments/create")
	public Appointments createAppointments(@RequestBody NewAppointment newAppointment) throws ParseException {
		java.sql.Date sqlDate = new java.sql.Date(newAppointment.getDate().getTime());
		return appointmentsService.createAppointment(newAppointment.getAmkaC(), newAppointment.getDoctorId(), sqlDate, newAppointment.getTime(),
				newAppointment.getIllnessDescription(), newAppointment.getComments());
	}

	@DeleteMapping("/appointments/delete/{id}")
	public Appointments deleteAppointments (@PathVariable Long id) {
		appointmentsService.deleteAppointments(id);
		return new Appointments();
	}

	@PutMapping("/appointments/update/{id}")
	public Appointments updateAppointmentsById(@PathVariable Long id, @RequestBody NewAppointment updatedAppointment) throws ParseException {
		java.sql.Date sqlDate = new java.sql.Date(updatedAppointment.getDate().getTime());
		appointmentsService.updateAppointment(id, sqlDate, updatedAppointment.getTime());
		return new Appointments();
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/pages/user/citizen/searchResults")
	public List<Appointments> getAppointmentsByDateAndSpecialty(@RequestParam(value = "specialtyId", required = false) Specialties specialtyId,
																@RequestParam(value = "fromDate", required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate,
																@RequestParam(value = "toDate", required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date toDate) throws ParseException {
		java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
		java.sql.Date sqlToDate = new java.sql.Date(toDate.getTime());
		return appointmentsService.searchAppointments(specialtyId, sqlFromDate, sqlToDate);
	}

//	@ResponseStatus(HttpStatus.OK)
//	@GetMapping("/appointments/search/date")
//	public List<Appointments> getAppointmentsByDate(@RequestParam(value = "fromDate", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate,
//													@RequestParam(value = "toDate", required = true) @DateTimeFormat(pattern="yyyy-MM-dd") Date toDate) throws ParseException {
//
//		java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
//		java.sql.Date sqlToDate = new java.sql.Date(toDate.getTime());
//		return appointmentsService.searchAppointments(sqlFromDate, sqlToDate);
//	}
//
//	@ResponseStatus(HttpStatus.OK)
//	@GetMapping("/appointments/search/illness")
//	public List<Appointments> getAppointmentsByIllness(@RequestParam(value = "illnessDescription", required = true) String illnessDescription) throws ParseException {
//		return appointmentsService.searchAppointments(illnessDescription);
//	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/pages/user/doctor/doctorSearchResults")
	public List<Appointments> getAppointmentsByDateAndIllness(@RequestParam(value = "fromDate", required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate,
													@RequestParam(value = "toDate", required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date toDate,
													@RequestParam(value = "illnessDescription", required = false) String illnessDescription) throws ParseException {
		if(fromDate!=null && toDate!=null && illnessDescription==null){
			java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
			java.sql.Date sqlToDate = new java.sql.Date(toDate.getTime());
			return appointmentsService.searchAppointments(sqlFromDate, sqlToDate);
		} else if(fromDate==null && toDate==null && illnessDescription!=null){
			return appointmentsService.searchAppointments(illnessDescription);
		}
		java.sql.Date sqlFromDate = new java.sql.Date(fromDate.getTime());
		java.sql.Date sqlToDate = new java.sql.Date(toDate.getTime());
		return appointmentsService.searchAppointments(sqlFromDate, sqlToDate, illnessDescription);
	}

}
