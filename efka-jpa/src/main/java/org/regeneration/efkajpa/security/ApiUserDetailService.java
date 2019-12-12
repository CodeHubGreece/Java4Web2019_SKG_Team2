package org.regeneration.efkajpa.security;

import org.regeneration.efkajpa.entity.Users;
import org.regeneration.efkajpa.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApiUserDetailService implements UserDetailsService {

    private UsersRepository userRepository;

    @Autowired
    public void setUserRepository(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // find user in repository
        Users user = userRepository.findByUsersname(username);
        if (user == null) {
            throw new UsernameNotFoundException("username not found");
        }


        ApiUserDetails userDetails = new ApiUserDetails(user.getUsername(), user.getPassword());
        return userDetails;
    }
}
