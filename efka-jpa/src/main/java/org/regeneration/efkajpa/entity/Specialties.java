package org.regeneration.efkajpa.entity;

import javax.persistence.*;
import java.security.spec.InvalidKeySpecException;
import java.util.Set;

@Entity
@Table(name = "specialties")
public class Specialties {
    private Integer specialtyId;
    private String specialty;
    private Doctors doctors;

    public Specialties(){}

    public Specialties(Integer specialtyId, String specialty){
        this.specialtyId = specialtyId;
        this.specialty = specialty;
    }

    @Id
    public Integer getSpecialtyId() {return specialtyId;}

    public void setSpecialtyId(Integer specialtyId) {this.specialtyId = specialtyId;}

    @Column
    public String getSpecialties() {return specialty;}
    public void setSpecialties(String specialty) {this.specialty = specialty;}

    @OneToMany(mappedBy = "specialty", cascade = CascadeType.ALL)
    @JoinColumn(name = "specialty")
    public Set<Doctors> getDoctors(){return doctors;}
    public void setDoctors(Doctors doctors){this.doctors = doctors;}
}
