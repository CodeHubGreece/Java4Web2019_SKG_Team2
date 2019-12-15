package org.regeneration.efkajpa.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "specialties")
public class Specialties {
    private Integer specialtyId;
    private String specialty;
    private List<Doctors> doctors;

    public Specialties(){}

    public Specialties(Integer specialtyId, String specialty){
        this.specialtyId = specialtyId;
        this.specialty = specialty;
    }

    @Id
    public Integer getSpecialtyId() {return specialtyId;}
    public void setSpecialtyId(Integer specialtyId) {this.specialtyId = specialtyId;}

    @Column
    public String getSpecialty() {return specialty;}
    public void setSpecialty(String specialty) {this.specialty = specialty;}

    /*@OneToMany(mappedBy = "specialties", cascade = CascadeType.ALL)
    public List<Doctors> getDoctors(){return doctors;}
    public void setDoctors(List<Doctors> doctors){this.doctors = doctors;}*/
}
