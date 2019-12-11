package org.regeneration.efkajpa.entity;

import javax.persistence.*;
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

    public Citizens(String amka, String lastName, String firstName, String  phone, String email, Users users){
        this.amka = amka;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phone = phone;
        this.email = email;
        this.users = users;
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
    public Users getUsers(){return users;}
    public void setUsers(Users users){this.users = users;}

    @OneToMany(mappedBy = "citizens", cascade = CascadeType.ALL)
    public Set<Appointments> getAppointments(){return appointments;}
    public void setAppointments(Set<Appointments> appointments){this.appointments = appointments;}

}
