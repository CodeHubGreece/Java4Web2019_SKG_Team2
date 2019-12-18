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

    public List<Appointments> searchAppointments(Specialties specialtyId, Date fromDate, Date toDate, String amka){
        List<Appointments> dateList = new ArrayList<Appointments>();
        List<Doctors> doctorsList = new ArrayList<Doctors>();
        List<Appointments> combinedList = new ArrayList<Appointments>();
        dateList = appointmentsRepository.findByDateBetween(fromDate, toDate);
        doctorsList = doctorRepository.findBySpecialties(specialtyId);
        for(int i=0; i<doctorsList.size(); i++){
            for(int j=0; j<dateList.size(); j++){
                if(doctorsList.get(i).getDoctorId().equals(dateList.get(j).getDoctors().getDoctorId())){
                    if(dateList.get(j).getCitizens().getAmka().equals(amka)){
                        combinedList.add(dateList.get(j));
                    }
                }
            }
        }
        return combinedList;
    }

    public List<Appointments> searchAppointments(Date fromDate, Date toDate, String doctorId){
        List<Appointments> dateList = new ArrayList<Appointments>();
        dateList = appointmentsRepository.findByDateBetween(fromDate, toDate);
        List<Appointments> resultList = new ArrayList<Appointments>();
        for(int i=0; i<dateList.size(); i++){
            if(doctorId.equals(dateList.get(i).getDoctors().getDoctorId())){
                resultList.add(dateList.get(i));
            }
        }
        return resultList;
    }

    public List<Appointments> searchAppointments(String illnessDescription, String doctorId){
        List<Appointments> illnessList = new ArrayList<Appointments>();
        illnessList = appointmentsRepository.findByIllnessDescription(illnessDescription);
        List<Appointments> resultList = new ArrayList<Appointments>();
        for(int i=0; i<illnessList.size(); i++){
            if(doctorId.equals(illnessList.get(i).getDoctors().getDoctorId())){
                resultList.add(illnessList.get(i));
            }
        }
        return resultList;
    }

    public List<Appointments> searchAppointments(Date fromDate, Date toDate, String illnessDescription, String doctorId){
        List<Appointments> dateList = new ArrayList<Appointments>();
        List<Appointments> illnessList = new ArrayList<Appointments>();
        List<Appointments> combinedList = new ArrayList<Appointments>();
        dateList = appointmentsRepository.findByDateBetween(fromDate, toDate);
        illnessList  = appointmentsRepository.findByIllnessDescription(illnessDescription);
        for(Appointments appointment : dateList){
            if(illnessList.contains(appointment)){
                if(doctorId.equals(appointment.getDoctors().getDoctorId())) {
                    combinedList.add(appointment);
                }
            }
        }
        return combinedList;
    }
}
