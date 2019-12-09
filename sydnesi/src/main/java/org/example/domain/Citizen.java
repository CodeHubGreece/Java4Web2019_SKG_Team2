package org.example.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "citizen")
public class Citizen {


    @Id
    @Column(name = "AMKA")
    private Long amka;
    @Column(name = "first_name")
    private String firstName;
    @Column(name ="last_name")
    private String lastName;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column (name = "User_Id")
    private int userId;

    public Citizen(){}

    public Citizen(Long amka, String lastName, String firstName, String  phone, String email,int userId){
        this.amka = amka;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;
        this.userId = userId;
    }


    public Long getAmka() { return amka; }
    public void setAmka(Long amka) { this.amka = amka; }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getuserId() {return userId;}
    public void setuserId(int userId) {this.userId = userId;}

}
