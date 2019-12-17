package org.regeneration.efkajpa.service;

import org.regeneration.efkajpa.entity.Appointments;
import org.regeneration.efkajpa.entity.Doctors;
import org.regeneration.efkajpa.entity.Specialties;
import org.regeneration.efkajpa.repository.AppointmentsRepository;
import org.regeneration.efkajpa.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentsService {
    @Autowired
    public AppointmentsRepository appointmentsRepository;

    @Autowired
    public DoctorRepository doctorRepository;

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
        appointmentsRepository.save(appointment);
    }

    public void deleteAppointments(Long id) {
        appointmentsRepository.deleteById(id);
   }

    public void updateAppointment(Long id, Date date, Time time){
        appointmentsRepository.findByAppointmentId(id).setDate(date);
        appointmentsRepository.findByAppointmentId(id).setTime(time);
        appointmentsRepository.flush();
    }

    public List<Appointments> searchAppointments(Specialties specialtyId, Date fromDate, Date toDate){
        List<Appointments> dateList = new ArrayList<Appointments>();
        List<Doctors> doctorsList = new ArrayList<Doctors>();
        List<Appointments> combinedList = new ArrayList<Appointments>();
        dateList = appointmentsRepository.findByDateBetween(fromDate, toDate);
        doctorsList = doctorRepository.findBySpecialties(specialtyId);
        for(int i=0; i<doctorsList.size(); i++){
            for(int j=0; j<dateList.size(); j++){
                if(doctorsList.get(i).getDoctorId().equals(dateList.get(j).getDoctors().getDoctorId())){
                    combinedList.add(dateList.get(j));
                }
            }
        }
        return combinedList;
    }

    public List<Appointments> searchAppointments(Date fromDate, Date toDate){
        return appointmentsRepository.findByDateBetween(fromDate, toDate);
    }

    public List<Appointments> searchAppointments(String illnessDescription){
        return appointmentsRepository.findByIllnessDescription(illnessDescription);
    }

    public List<Appointments> searchAppointments(Date fromDate, Date toDate, String illnessDescription){
        List<Appointments> dateList = new ArrayList<Appointments>();
        List<Appointments> illnessList = new ArrayList<Appointments>();
        List<Appointments> combinedList = new ArrayList<Appointments>();
        dateList = appointmentsRepository.findByDateBetween(fromDate, toDate);
        illnessList  = appointmentsRepository.findByIllnessDescription(illnessDescription);
        for(Appointments appointment : dateList){
            if(illnessList.contains(appointment)){
                combinedList.add(appointment);
            }
        }
        return combinedList;
    }
}
