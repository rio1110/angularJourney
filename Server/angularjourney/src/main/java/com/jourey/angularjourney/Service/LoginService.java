package com.jourey.angularjourney.Service;

import java.util.Collection;

import com.jourey.angularjourney.Entity.User;
import com.jourey.angularjourney.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Transactional
public class LoginService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException{
        User user = userRepository.findByEmail(userName);

        if(user == null) {
            throw new UsernameNotFoundException("Email "+userName+ "not found");
        }

        return user;
    }
}