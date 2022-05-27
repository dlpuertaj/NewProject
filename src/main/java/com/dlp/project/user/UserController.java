package com.dlp.project.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Integer userId){
        return userService.findUserById(userId);
    }

    @PostMapping
    public void saveNewUser(@RequestBody UserDTO user){
        userService.saveNewUser(user);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(Integer userId){
        userService.deleteUser(userId);
    }

    @PutMapping("/{userId}")
    public void updateUser(@PathVariable Integer userId, @RequestBody UserDTO user){
        userService.updateUser(user);
    }
}
