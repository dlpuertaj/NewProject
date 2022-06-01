package com.dlp.project.user;

import com.dlp.project.api.ApiResponse;
import com.dlp.project.exceptions.UserApiException;
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
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers(){
        ApiResponse<List<User>> responseBody;
        try {
            List<User> users =  userService.findAllUsers();
            responseBody = new ApiResponse<>(users,"Users found successfully");
        }catch(UserApiException e){
            ApiResponse<List<User>> errorResponse = new ApiResponse<>(new ArrayList<>(),e.getMessage());
            return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<User>> getUserById(@PathVariable Integer userId) {
        ApiResponse<User> responseBody;
        try {
            User userFound = userService.findUserById(userId);
            responseBody = new ApiResponse<>(userFound,"User fetched successfully");

        } catch (UserApiException e) {
            ApiResponse<User> errorResponse = new ApiResponse<>(new User(),e.getMessage());
            return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Integer>> saveNewUser(@RequestBody UserDTO user){
        ApiResponse<Integer> responseBody;
        try {
            Integer newId = userService.saveNewUser(user);
            responseBody = new ApiResponse<>(newId,"New User saved successfully");
        }catch(UserApiException e){
            ApiResponse<Integer> errorResponse = new ApiResponse<>(-1,e.getMessage());
            return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
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
