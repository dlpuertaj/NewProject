package com.dlp.project.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User findUserById(Integer userId) {
        return null;
    }

    @Override
    public Integer saveNewUser(User newUser) {
        return null;
    }

    @Override
    public void DeleteUser(Integer userId) {

    }

    @Override
    public void updateUser(User user) {

    }
}
