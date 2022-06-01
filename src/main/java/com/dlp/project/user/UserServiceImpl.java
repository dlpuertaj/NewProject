package com.dlp.project.user;

import com.dlp.project.exceptions.UserApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User findUserById(Integer userId) throws UserApiException{
        Optional<User> optionalUser = userRepository.findById(userId);
            return optionalUser.orElseThrow(() -> new UserApiException("User not found"));
    }

    @Override
    public Integer saveNewUser(UserDTO newUser) {
        return userRepository.save(User.builder()
                .username(newUser.getUsername())
                .password(newUser.getPassword())
                .build()).getId();
    }

    @Override
    public void deleteUser(Integer userId) {
        // Find user
        Optional<User> userFound = userRepository.findById(userId);

        try {
            User user = userFound.orElseThrow(NullPointerException::new);
            userRepository.delete(user);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateUser(UserDTO user) {
        Optional<User> userFound = userRepository.findById(user.getId());

        try {
            User userToUpdate = userFound.orElseThrow(NullPointerException::new);
            userToUpdate.setUsername(user.getUsername());
            userToUpdate.setPassword(user.getPassword());
            userRepository.save(userToUpdate);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
