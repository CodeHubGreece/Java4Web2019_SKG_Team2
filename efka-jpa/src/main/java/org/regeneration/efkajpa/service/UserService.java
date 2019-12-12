package org.regeneration.efkajpa.service;

import org.regeneration.efkajpa.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserService {

    @Autowired
    public UsersRepository usersRepository;

}
