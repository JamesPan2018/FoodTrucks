package com.mfft.foodtrucks.service;

import com.mfft.foodtrucks.model.User;

public interface UserService {

    User loadUserByUsername(String username);
}
