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
    private String username;
    private String password;

    public CitizenJpa(){}

    public CitizenJpa(Long amka, String lastName, String firstName, String  phone, String email, String username, String password){
        this.amka = amka;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;

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
    public String getUsername(){return username;}
    public String setUsername(String username){return this.username = username;}

    @Column
    public String getPassword(){return password;}
    public String setPassword(String password){return this.password = password;}
}
