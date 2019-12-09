package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Doctor")
public class Doctor {

    @Id
    @Column(name="DoctorId")
    private Long doctor_id;
    @Column (name="Last_Name")
    private String LastName;
    @Column (name = "First_Name")
    private String FirstName;
    @Column (name = "specialty")
    private int specialty;
    @Column (name = "user_id")
    private int user_id;

    public Doctor(){}

    public Long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Long doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public int getSpecialty() {
        return specialty;
    }

    public void setSpecialty(int specialty) {
        this.specialty = specialty;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}

