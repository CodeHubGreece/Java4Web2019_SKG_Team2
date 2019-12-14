package org.regeneration.efkajpa.repository;

import org.regeneration.efkajpa.entity.Doctors;
import org.regeneration.efkajpa.entity.Specialties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface DoctorRepository extends JpaRepository<Doctors, String> {
    Set<Doctors> findBySpecialties(Specialties specialty);
    Doctors findByDoctorId(String doctorId);
    List<Doctors> findAll();
}
