package com.dlp.project.user;

import com.dlp.project.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User findUserById(Integer userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        try {
            return optionalUser.orElseThrow(UserNotFoundException::new);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Integer saveNewUser(User newUser) {
        return userRepository.save(newUser).getId();
    }

    @Override
    public void DeleteUser(Integer userId) {
        // Not done yet
    }

    @Override
    public void updateUser(User user) {
        // Not done yet
    }
}
