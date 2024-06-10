package com.example.TH_buoi3.services;

import com.example.TH_buoi3.entity.User;
import com.example.TH_buoi3.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public void save(User user){
        userRepository.save(user);
    }
}
