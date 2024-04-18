package com.mfft.foodtrucks.service.impl;

import com.mfft.foodtrucks.model.User;
import com.mfft.foodtrucks.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User loadUserByUsername(String username) {
        // should load User object from database, I just make a hard code here
        User user = new User("admin","admin");
        return user;
    }
}
