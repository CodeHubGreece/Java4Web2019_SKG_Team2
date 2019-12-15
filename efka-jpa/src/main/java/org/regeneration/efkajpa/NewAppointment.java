package org.regeneration.efkajpa;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.sql.Time;

public class NewAppointment {
    private String amkaC;
    private String doctorId;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;
    private Time time;
    private String illnessDescription;
    private String comments;

    public NewAppointment(){}

    public NewAppointment(String amkaC, String doctorId, Date date, Time time, String illnessDescription, String comments) {
        this.amkaC = amkaC;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
        this.illnessDescription = illnessDescription;
        this.comments = comments;
    }

    public NewAppointment(Date date, Time time) {
        this.date = date;
        this.time = time;
    }

    public String getAmkaC(){
        return amkaC;
    }

    public void setAmkaC(String amkaC) {
        this.amkaC = amkaC;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getIllnessDescription() {
        return illnessDescription;
    }

    public void setIllnessDescription(String illnessDescription) {
        this.illnessDescription = illnessDescription;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
