package com.example.TH_buoi3.services;

import com.example.TH_buoi3.entity.User;
import com.example.TH_buoi3.repository.IUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class CustomUserDetail implements UserDetails {
    private final User user;

    private final IUserRepository userRepository;

    public CustomUserDetail(User user, IUserRepository userRepository){
        this.user=user;
        this.userRepository = userRepository;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return Arrays.stream(userRepository.getRolesOfUser(user.getId()))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
//        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//        String[] roles = userRepository.getRolesOfUser(user.getId());
//        for(String role : roles){
//            authorities.add(new SimpleGrantedAuthority(role));
//        }
//        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
