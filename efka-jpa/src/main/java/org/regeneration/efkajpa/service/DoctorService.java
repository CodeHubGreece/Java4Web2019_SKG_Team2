package org.regeneration.efkajpa.service;

import org.regeneration.efkajpa.entity.Doctors;
import org.regeneration.efkajpa.entity.Specialties;
import org.regeneration.efkajpa.entity.Users;
import org.regeneration.efkajpa.repository.DoctorRepository;
import org.regeneration.efkajpa.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    public DoctorRepository doctorRepository;

    @Autowired
    public CitizenService citizenService;

    public List<Doctors> retrieveBySpecialty(Specialties specialty){
        return doctorRepository.findBySpecialties(specialty);
    }

    public Doctors retrieveByDoctorId(String doctorId){
        return doctorRepository.findByDoctorId(doctorId);
    }

    public List<Doctors> findAll() {
        return doctorRepository.findAll();
    }

}
