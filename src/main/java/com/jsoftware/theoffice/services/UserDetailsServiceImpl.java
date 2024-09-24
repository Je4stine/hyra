package com.jsoftware.theoffice.services;

import com.jsoftware.theoffice.models.User;
import com.jsoftware.theoffice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found" + username));

        return new CustomUserDetails(
                user.getUsername(),
                user.getPassword(),
                user.getFirstname(),
                user.getLastname(),
                user.isEnable(),
                user.getAuthorities()
        );
    }
}


//return new org.springframework.security.core.userdetails.User(
//        user.getUsername(),
//                user.getPassword(),
//                user.isEnable(),
//                true,true,true,
//                        user.getAuthorities()
//        );