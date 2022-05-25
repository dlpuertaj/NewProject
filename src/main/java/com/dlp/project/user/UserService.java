package com.dlp.project.user;


import java.util.List;

public interface UserService {
    User findUserById(Integer userId);
    Integer saveNewUser(User newUser);
    void deleteUser(Integer userId);
    void updateUser(User user);
    List<User> findAllUsers();
}
