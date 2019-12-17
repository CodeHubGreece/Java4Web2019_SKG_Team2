package org.regeneration.efkajpa.service;

import org.regeneration.efkajpa.entity.Citizens;
import org.regeneration.efkajpa.entity.Users;
import org.regeneration.efkajpa.repository.CitizenRepository;
import org.regeneration.efkajpa.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.NameAlreadyBoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewUserService {
    @Autowired
    public UsersRepository usersRepository;

    @Autowired
    public CitizenRepository citizenRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    public Users retrieve(String username){
        return usersRepository.findByUsername(username);
    }

    public void store(String amka, String lastName, String firstName, String email, String username, String password,
                      String phone, String userType) throws NameAlreadyBoundException {
        if(!usersRepository.existsByUsername(username)) {
            if(!citizenRepository.existsByAmka(amka)) {
                Users user = new Users(username, passwordEncoder.encode(password), userType.charAt(0));
                //Users user = new Users(username, password, userType.charAt(0));
                usersRepository.save(user);

                Citizens citizen = new Citizens(amka, lastName, firstName, email, phone, user);
                citizenRepository.save(citizen);
            } else {
                throw new NameAlreadyBoundException("This AMKA number already exists");
            }
        }
        else {
            throw new NameAlreadyBoundException("Username already exists");
        }
    }

    public void updatePass(){
        List<Users> users = new ArrayList<Users>();
        users = usersRepository.findAll();
        for(Users u : users){
            String i = u.getPassword();
            u.setPassword(passwordEncoder.encode(i));
        }
        usersRepository.flush();
    }
}
