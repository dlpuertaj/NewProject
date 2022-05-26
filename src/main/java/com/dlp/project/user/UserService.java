package com.dlp.project.user;


import java.util.List;

public interface UserService {
    User findUserById(Integer userId);
    Integer saveNewUser(UserDTO newUser);
    void deleteUser(Integer userId);
    void updateUser(UserDTO user);
    List<User> findAllUsers();
}
