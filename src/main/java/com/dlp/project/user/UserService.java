package com.dlp.project.user;


public interface UserService {
    User findUserById(Integer userId);
    Integer saveNewUser(User newUser);
    void DeleteUser(Integer userId);
    void updateUser(User user);
}
