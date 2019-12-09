package org.regeneration.efkajpa.entity;

import javax.persistence.*;
import java.security.spec.InvalidKeySpecException;
import java.util.Set;

@Entity
@Table(name = "specialties")
public class Specialties {
    private Long specialtyId;
    private String specialty;
    private Set<Doctors> doctors;

    public Specialties(){}

    public Specialties(Long specialtyId, String specialty){
        this.specialtyId = specialtyId;
        this.specialty = specialty;
    }

    @Id
    public Long getSpecialtyId() {return specialtyId;}
    public void setSpecialtyId(Long specialtyId) {this.specialtyId = specialtyId;}

    @Column
    public String getSpecialties() {return specialty;}
    public void setSpecialties(String specialty) {this.specialty = specialty;}

    @OneToMany(mappedBy = "specialty", cascade = CascadeType.ALL)
    public Set<Doctors> getDoctors(){return doctors;}
    public void setDoctors(Set<Doctors> doctors){this.doctors = doctors;}
}
