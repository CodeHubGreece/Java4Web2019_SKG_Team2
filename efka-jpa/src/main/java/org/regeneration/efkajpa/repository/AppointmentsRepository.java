package org.regeneration.efkajpa.repository;

import org.regeneration.efkajpa.entity.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface AppointmentsRepository extends JpaRepository<Appointments, Long> {
    Appointments findByAppointmentId(Long id);
    void deleteById(Long id);
    List<Appointments> findByDateBetween(Date fromDate, Date toDate);
    List<Appointments> findByIllnessDescription(String illnessDescription);
}
