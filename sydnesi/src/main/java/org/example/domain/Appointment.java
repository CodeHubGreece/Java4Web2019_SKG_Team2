package org.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Appointment")
public class Appointment {

    @Id
    @Column(name = "appointmentID")
    private Integer appointmentID;
    @Column(name = "AMKA_C")
    private String amkaC;
    @Column(name = "doctor_ID")
    private String doctorId;
    @Column(name = "Time")
    private String time;
    @Column(name = "Date")
    private String date;
    @Column(name = "Illness_description")
    private String illnessdescription;
    @Column(name = "Comments")
    private String comments;

    public Appointment(){}

    public Appointment(Integer appointmentID, String amkaC, String doctorId, String  time,
                       String date ,String illnessdescription,String comments){
        this. appointmentID= appointmentID;
        this.amkaC= amkaC;
        this.doctorId= doctorId;
        this.time = time;
        this.date= date;
        this.illnessdescription = illnessdescription;
        this.comments = comments;
    }

    public int getappointmentID() {
        return appointmentID;
    }

    public int appointmentID() {
        return appointmentID;
    }

    public void setAkaC(String lastName) { this.amkaC = amkaC ;}

    public String getDoctorΙd() { return doctorId; }

    public void setDoctorΙd(String firstName) { this.doctorId = doctorId; }

    public String getTime() { return time; }

    public void setTime(String Time) { this.time= Time; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date=date; }

    public String getillnessDescription() { return illnessdescription; }

    public void setIllnessDescription(String illnessDescription) {
        this.illnessdescription = illnessdescription;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String Comments) {
        this.comments = Comments;
    }

}