package com.dlp.project.user;


import com.dlp.project.exceptions.UserApiException;

import java.util.List;

public interface UserService {
    User findUserById(Integer userId) throws UserApiException;
    Integer saveNewUser(UserDTO newUser);
    void deleteUser(Integer userId);
    void updateUser(UserDTO user);
    List<User> findAllUsers();
}
