package org.regeneration.efkajpa.entity;

import javax.persistence.*;

@Entity
@Table(name="appointments")
public class Appointments {
    private Long appointmentID;
    private String amkaC;
    private String doctorId;
    private String time;
    private String date;
    private String illnessDescription;
    private String comments;
    private Citizens citizens;
    private  Doctors doctors;

    public Appointments(){}

    public Appointments(String amkaC, String doctorId, String time, String date, String illnessDescription, String comments){
        this.amkaC = amkaC;
        this.doctorId = doctorId;
        this.time = time;
        this.date = date;
        this.illnessDescription = illnessDescription;
        this.comments = comments;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getAppointmentsID() {
        return appointmentID;
    }
    public void setAppointmentID(Long appointmentID) {
        this.appointmentID = appointmentID;
    }

    @ManyToOne
    @JoinColumn(name = "amka_C")
    public Citizens getCitizens(){return citizens;}
    public void setCitizens(Citizens citizens) {this.citizens = citizens;}

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    public Doctors getDoctors(){return doctors;}
    public void setDoctors(Doctors doctors) {this.doctors = doctors;}

    @Column
    public String getTime(){return time;}
    public void setTime(String time){this.time = time;}

    @Column
    public String getDate(){return date;}
    public void setDate(String date){this.date = date;}

    @Column
    public String getIllnessDescription(){return illnessDescription;}
    public void setIllnessDescription(String illnessDescription){this.illnessDescription = illnessDescription;}

    @Column
    public String getComments(){return comments;}
    public void setComments(String comments){this.comments = comments;}

}