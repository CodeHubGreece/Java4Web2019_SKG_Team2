package org.regeneration.efkajpa.repository;

import org.regeneration.efkajpa.entity.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentsRepository extends JpaRepository<Appointments, Long> {
    Appointments findByAppointmentId(Long id);

}
