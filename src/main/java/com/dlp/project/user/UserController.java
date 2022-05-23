package com.dlp.project.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="app/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void createUser(@RequestBody User newUser){
        userService.saveNewUser(newUser);
    }

    @GetMapping("{userId}")
    public User getUserById(@PathVariable Integer userId){
        User userFound = userService.findUserById(userId);
        return userFound;
    }
}
