package org.regeneration.efkajpa.service;

import org.regeneration.efkajpa.entity.Appointments;
import org.regeneration.efkajpa.repository.AppointmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentsService {
    @Autowired
    public AppointmentsRepository appointmentsRepository;

    public Appointments findAppointmentById(Long id) {
        return appointmentsRepository.findByAppointmentId(id);
    }

    public void deleteAppointments(Long id) {
        appointmentsRepository.deleteById(id);
    }
    public Appointments updateAppointmentsById(Long id){
        return appointmentsRepository.updateAppointmentsById(id);

    }



}
