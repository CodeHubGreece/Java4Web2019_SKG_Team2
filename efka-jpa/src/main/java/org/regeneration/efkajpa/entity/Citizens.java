package org.regeneration.efkajpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "citizens")
public class Citizens {
    private String amka;
    private String lastName;
    private String firstName;
    private String phone;
    private String email;
    private Users user;

    public Citizens(){}

    public Citizens(String amka, String lastName, String firstName, String  phone, String email){
        this.amka = amka;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;
    }

    @Id
    @Column(length = 11)
    public String getAmka(){return amka;}
    public void setAmka(String amka){this.amka = amka;}

    @Column
    public String getLastName(){return lastName;}
    public void setLastName(String lastName){this.lastName = lastName;}

    @Column
    public String getFirstName(){return firstName;}
    public void setFirstName(String firstName){this.firstName = firstName;}

    @Column
    public String getPhone(){return phone;}
    public void setPhone(String phone){this.phone = phone;}

    @Column
    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public Users getUsers(){return user;}
    public void setUsers(Users user){this.user = user;}

}
