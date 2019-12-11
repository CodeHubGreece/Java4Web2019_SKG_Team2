package org.regeneration.efkajpa.service;

import org.regeneration.efkajpa.entity.Doctors;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    public Doctors retrieve (String id){
        return new Doctors();
    }

}
