package org.regeneration.efkajpa.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name="appointments")
public class Appointments {
    private Long appointmentId;
    private String amkaC;
    private String doctor_id;
    private Time time;
    private Date date;
    private String illnessDescription;
    private String comments;
    private Citizens citizens;
    private  Doctors doctors;

    public Appointments(){}

    /*public Appointments(Citizens citizens, Doctors doctors, Date date, Time time, String illnessDescription, String comments){
        this.citizens = citizens;
        this.doctors = doctors;
        this.date = date;
        this.time = time;
        this.illnessDescription = illnessDescription;
        this.comments = comments;
    }*/
    public Appointments(Citizens citizens, Doctors doctors, Date date, Time time, String illnessDescription, String comments){
        this.amkaC = citizens.getAmka();
        this.doctor_id = doctors.getDoctorId();
        this.date = date;
        this.time = time;
        this.illnessDescription = illnessDescription;
        this.comments = comments;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getAppointmentId() {
        return appointmentId;
    }
    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
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
    public Date getDate(){return date;}
    public void setDate(Date date){this.date = date;}

    @Column
    public Time getTime(){return time;}
    public void setTime(Time time){this.time = time;}

    @Column
    public String getIllnessDescription(){return illnessDescription;}
    public void setIllnessDescription(String illnessDescription){this.illnessDescription = illnessDescription;}

    @Column
    public String getComments(){return comments;}
    public void setComments(String comments){this.comments = comments;}

}