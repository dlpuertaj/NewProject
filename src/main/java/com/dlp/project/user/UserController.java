package com.dlp.project.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void saveUser(@RequestBody UserDTO user){
        userService.saveNewUser(user);
    }

    @GetMapping("{userId}")
    public User getUserById(@PathVariable Integer userId){
        return userService.findUserById(userId);
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.findAllUsers();
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(Integer userId){
        userService.deleteUser(userId);
    }

    @PutMapping
    public void updateUser(UserDTO user){
        userService.updateUser(user);
    }
}
