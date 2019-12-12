package org.regeneration.efkajpa.service;

import org.regeneration.efkajpa.entity.Users;
import org.regeneration.efkajpa.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    public UsersRepository usersRepository;

    public Users retrieve(String username){
        return usersRepository.findByUsername(username);
    }
}
