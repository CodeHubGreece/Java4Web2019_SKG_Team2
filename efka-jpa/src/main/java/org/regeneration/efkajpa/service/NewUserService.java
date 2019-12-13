package org.regeneration.efkajpa.service;

import org.regeneration.efkajpa.entity.Citizens;
import org.regeneration.efkajpa.entity.Users;
import org.regeneration.efkajpa.repository.CitizenRepository;
import org.regeneration.efkajpa.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewUserService {
    @Autowired
    public UsersRepository usersRepository;

    @Autowired
    public CitizenRepository citizenRepository;

    public Users retrieve(String username){
        return usersRepository.findByUsername(username);
    }

    public void store(String amka, String lastName, String firstName, String email, String username, String password, String phone, String type){
        Users user = new Users(username, password, type.charAt(0));
        usersRepository.save(user);
        Citizens citizen = new Citizens(amka, lastName, firstName, email, phone, user);
        citizenRepository.save(citizen);
    }
}
