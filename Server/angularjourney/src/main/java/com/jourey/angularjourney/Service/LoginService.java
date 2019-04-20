package com.jourey.angularjourney.Service;

import com.jourey.angularjourney.Entity.User;
import com.jourey.angularjourney.Repository.UserRepository;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service("userDetailsService")
public class LoginService implements UserDetailsService {

    private final UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String email) {
        // emailでデータベースからユーザーエンティティを検索する
        if (StringUtils.isEmpty(email)) {
            throw new UsernameNotFoundException("Username is empty");
        }
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found for name: " + email);
        }
        return user;
    }
}