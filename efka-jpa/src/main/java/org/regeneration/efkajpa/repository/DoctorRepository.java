package org.regeneration.efkajpa.repository;

import org.regeneration.efkajpa.entity.Doctors;
import org.regeneration.efkajpa.entity.Specialties;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctors, String> {
    Doctors findBySpecialty(Specialties specialty);
}
