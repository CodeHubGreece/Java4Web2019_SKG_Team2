package org.regeneration.efkajpa.security;

import org.regeneration.efkajpa.UserInfo;
import org.regeneration.efkajpa.entity.Appointments;
import org.regeneration.efkajpa.entity.Users;
import org.regeneration.efkajpa.repository.CitizenRepository;
import org.regeneration.efkajpa.repository.DoctorRepository;
import org.regeneration.efkajpa.repository.UsersRepository;
import org.regeneration.efkajpa.service.CitizenService;
import org.regeneration.efkajpa.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CitizenService citizenService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    public void setUserRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public ApiUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("username not found");
        }
        System.out.println(user.getUsername() + "\n" + user.getPassword() + "\n" + user.getType());
        return new ApiUserDetails(user.getUsername(), user.getPassword());
    }

    public UserInfo getUserByUsername(String username) throws UsernameNotFoundException{
        Users user = usersRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("username not found");
        }

        if(user.getType()=='D'){
            return new UserInfo(doctorService.retrieveByUserId(user).getDoctorId(), 'D');
        } else if(user.getType()=='C'){
            return new UserInfo(citizenService.retrieveByUserId(user).getAmka(), 'C');
        }
        return null;
    }

}