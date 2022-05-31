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
            responseBody = new ApiResponse<>(users,"Users found successfuly",new ArrayList<>());
        }catch(UserApiException e){
            List<String> errorList = new ArrayList<>();
            errorList.add(e.getExceptionMessage());
            ApiResponse<List<User>> errorResponse = new ApiResponse<>(new ArrayList<>(),
                                                                      e.getMessage(),
                                                                      errorList);
            return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<User>> getUserById(@PathVariable Integer userId) {
        ApiResponse<User> responseBody;
        try {
            User userFound = userService.findUserById(userId);
            responseBody = new ApiResponse<>(userFound,
                    "User fetched successfully", new ArrayList<>());

        } catch (UserApiException e) {
            List<String> errorList = new ArrayList<>();
            errorList.add(e.getExceptionMessage());
            ApiResponse<User> errorResponse = new ApiResponse<>(new User(),e.getMessage(),errorList);
            return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
        }
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
