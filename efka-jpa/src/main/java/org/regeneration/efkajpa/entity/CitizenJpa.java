package org.regeneration.efkajpa.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class CitizenJpa {
    private Long amka;
    private String lastName;
    private String firstName;
    private String phone;
    private String email;
    private String userId;

    public CitizenJpa(){}

    public CitizenJpa(Long amka, String lastName, String firstName, String  phone, String email, String userId){
        this.amka = amka;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;
        this.userId = userId;
    }

    @Id
    public Long getAmka(){return amka;}
    public Long setAmka(Long amka){return this.amka = amka;}

    @Column
    public String getLastName(){return lastName;}
    public String setLastName(String lastName){return this.lastName = lastName;}

    @Column
    public String getFirstName(){return firstName;}
    public String setFirstName(String firstName){return this.firstName = firstName;}

    @Column
    public String getPhone(){return phone;}
    public String setPhone(String phone){return this.phone = phone;}

    @Column
    public String getEmail(){return email;}
    public String setEmail(String email){return this.email = email;}

    @Column
    public String getUserId(){return userId;}
    public String setUserId(String userId){return this.userId = userId;}

}
