package org.regeneration.efkajpa.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "citizens")
public class Citizens {
    private String amka;
    private String lastName;
    private String firstName;
    private String phone;
    private String email;
    private Users users;
    private Set<Appointments> appointments;

    public Citizens(){}

    public Citizens(String amka, String lastName, String firstName, String email, String phone, Users users){
        this.amka = amka;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phone = phone;
        this.users = users;
    }

    @Id
    @Column
    @Length(min = 11, max = 11)
    public String getAmka(){return amka;}
    public void setAmka(String amka){this.amka = amka;}

    @Column
    public String getLastName(){return lastName;}
    public void setLastName(String lastName){this.lastName = lastName;}

    @Column
    public String getFirstName(){return firstName;}
    public void setFirstName(String firstName){this.firstName = firstName;}

    @Column
    @Length(min = 10, max = 10)
    public String getPhone(){return phone;}
    public void setPhone(String phone){this.phone = phone;}

    @Column
    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public Users getUsers(){return users;}
    public void setUsers(Users users){this.users = users;}

    /*@OneToMany(mappedBy = "citizens", cascade = CascadeType.ALL)
    public Set<Appointments> getAppointments(){return appointments;}
    public void setAppointments(Set<Appointments> appointments){this.appointments = appointments;}*/

}
