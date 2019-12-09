package org.regeneration.efkajpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    private Integer id;
    private String username;
    private String password;
    private char type;
    private Citizens citizen;
    private Doctors doctor;

    public Users() {
    }

    public Users(String username, String password, char type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){this.id = id;}

    @Column
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){this.username = username;}

    @Column
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){this.password = password;}

    @Column
    public char getType(){
        return type;
    }
    public void setType(char type){this.type = type; }

    @OneToOne(mappedBy = "users")
    public Citizens getCitizens(){return citizen;}
    public void setCitizens(Citizens citizen){this.citizen = citizen;}

    @OneToOne(mappedBy = "users")
    public Doctors getDoctors(){return doctor;}
    public void setDoctors(Doctors doctor){this.doctor = doctor;}
}
