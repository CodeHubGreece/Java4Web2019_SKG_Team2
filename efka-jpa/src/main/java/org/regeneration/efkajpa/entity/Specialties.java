package org.regeneration.efkajpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.security.spec.InvalidKeySpecException;

@Entity
public class Specialties {
    private Integer specialtyId;
    private String specialty;

    public Specialties(){}

    public Specialties(Integer specialtyId, String specialty){
        this.specialtyId = specialtyId;
        this.specialty = specialty;
    }

    @Column
    public Integer getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Integer specialtyId) {
        this.specialtyId = specialtyId;
    }

    @Column
    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
