package com.dlp.project.user;

import com.dlp.project.api.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<ApiResponse<User>> getUserById(@PathVariable Integer userId){
        ApiResponse<User> responseBody = new ApiResponse<>(userService.findUserById(userId),
                "User fetched successfully",new ArrayList<>());
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
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
