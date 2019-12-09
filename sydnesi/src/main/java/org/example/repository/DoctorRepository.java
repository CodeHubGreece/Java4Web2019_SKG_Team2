package org.example.repository;

import org.example.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
// kanw create ena interface doctorrepository poy kanei extends panta JpaRepositiry<>
//mesa sta <> mpainei to onoma tis class kai o typos tou PK  (String,Long h int klp)
public interface DoctorRepository extends JpaRepository <Doctor,Long>{ 

}
