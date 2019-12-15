package org.regeneration.efkajpa.service;

import org.regeneration.efkajpa.entity.Citizens;
import org.regeneration.efkajpa.repository.CitizenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CitizenService {
    @Autowired
    public CitizenRepository citizenRepository;

    public Citizens retrieveByAmka(String amka){
        return citizenRepository.findByAmka(amka);
    }
}
