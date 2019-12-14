package org.regeneration.efkajpa.service;

import org.regeneration.efkajpa.entity.Appointments;
import org.regeneration.efkajpa.repository.AppointmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;

@Service
public class AppointmentsService {
    @Autowired
    public AppointmentsRepository appointmentsRepository;

    @Autowired
    public CitizenService citizenService;

    @Autowired
    public DoctorService doctorService;

    public Appointments findAppointmentById(Long id){
        return appointmentsRepository.findByAppointmentId(id);
    }

    public void createAppointment(String amkaC, String doctorId, Date date, Time time, String illnessDescription, String comments){
        Appointments appointment = new Appointments(citizenService.retrieveByAmka(amkaC), doctorService.retrieveByDoctorId(doctorId),
                date, time, illnessDescription, comments);
        System.out.println(appointment.getDate() + "\n" + appointment.getTime());
        appointmentsRepository.save(appointment);
        System.out.println(appointment.getDate() + "\n" + appointment.getTime());
    }

    public void deleteAppointments(Long id) {
        appointmentsRepository.deleteById(id);
   }

    public void updateAppointment(Long id, Date date, Time time){
        appointmentsRepository.findByAppointmentId(id).setDate(date);
        appointmentsRepository.findByAppointmentId(id).setTime(time);
        appointmentsRepository.flush();
    }
}
