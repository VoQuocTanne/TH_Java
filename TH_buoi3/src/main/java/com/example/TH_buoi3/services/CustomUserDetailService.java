package com.example.TH_buoi3.services;

import com.example.TH_buoi3.entity.User;
import com.example.TH_buoi3.services.CustomUserDetail;
import com.example.TH_buoi3.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username);
        if(user == null)
            throw new UsernameNotFoundException("User no found");
        return new CustomUserDetail(user, userRepository);
    }

}
