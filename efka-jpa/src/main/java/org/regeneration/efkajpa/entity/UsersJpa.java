package org.regeneration.efkajpa.entity;

import javax.persistence.*;

@Entity
public class UsersJpa {
    private Integer id;
    private String username;
    private String password;
    private char type;

    public UsersJpa() {
    }

    public UsersJpa(String username, String password, char type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId(){
        return id;
    }

    @Column
    public String getUsername(){
        return username;
    }

    @Column
    public String getPassword(){
        return password;
    }

    @Column
    public char getType(){
        return type;
    }

    public Integer setId(Integer id) {
        return this.id = id;
    }

    public String setUsername(String username) {
        return this.username = username;
    }

    public String setPassword(String password) {
        return this.password = password;
    }

    public char setType(char type) {
        return this.type = type;
    }
}
