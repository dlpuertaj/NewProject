package com.dlp.project.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void createUser(@RequestBody UserDTO user){
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        userService.saveNewUser(newUser);
    }

    @GetMapping("{userId}")
    public User getUserById(@PathVariable Integer userId){
        return userService.findUserById(userId);
    }
}
