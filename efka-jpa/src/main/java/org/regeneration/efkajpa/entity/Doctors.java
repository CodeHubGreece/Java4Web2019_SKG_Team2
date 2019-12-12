package org.regeneration.efkajpa.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "doctors")
public class Doctors {
    private String doctorId;
    private String lastName;
    private String firstName;
    private Specialties specialties;
    private Users users;
    private Set<Appointments> appointments;

    public Doctors(){}

    public Doctors(String lastName, String firstName, Specialties specialty) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.specialties = specialty;
    }

    @Id
    @Column(length = 5)
    public String getDoctorId() {return doctorId;}
    public void setDoctorId(String doctorId) {this.doctorId = doctorId;}

    @Column
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    @Column
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    public Specialties getSpecialties(){return specialties;}
    public void setSpecialties(Specialties specialties){this.specialties = specialties;}

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    public Users getUsers(){return users;}
    public void setUsers(Users users){this.users = users;}

    /*@OneToMany(mappedBy = "doctors", cascade = CascadeType.ALL)
    public Set<Appointments> getAppointments(){return appointments;}
    public void setAppointments(Set<Appointments> appointments){this.appointments = appointments;}*/

}
