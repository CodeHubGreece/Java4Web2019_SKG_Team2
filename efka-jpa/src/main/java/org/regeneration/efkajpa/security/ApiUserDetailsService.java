package org.regeneration.efkajpa.security;

import org.regeneration.efkajpa.entity.Users;
import org.regeneration.efkajpa.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public class ApiUserDetailsService implements UserDetailsService {

    private UsersRepository usersRepository;

    @Autowired
    public void setUserRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public ApiUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByUsername(username);
        if (user == null) {
            System.out.println("1111111111111111111111111111");
            throw new UsernameNotFoundException("username not found");
        }
        System.out.println(user.getUsername() + "\n" + user.getPassword() + "\n" + user.getType());
        return new ApiUserDetails(user.getUsername(), user.getPassword(), user.getType());
    }
}