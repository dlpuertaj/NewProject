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
        User newUser = User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();

        userService.saveNewUser(newUser);
    }

    @GetMapping("{userId}")
    public User getUserById(@PathVariable Integer userId){
        return userService.findUserById(userId);
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.findAllUsers();
    }
}
