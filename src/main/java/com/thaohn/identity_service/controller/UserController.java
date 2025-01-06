package com.thaohn.identity_service.controller;

import com.thaohn.identity_service.dto.request.ApiResponse;
import com.thaohn.identity_service.dto.request.UserCreationRequest;
import com.thaohn.identity_service.dto.request.UserUpdateRequest;
import com.thaohn.identity_service.dto.response.UserResponse;
import com.thaohn.identity_service.entity.User;
import com.thaohn.identity_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));

        return apiResponse;
    }

    @GetMapping
    List<User> getUsers(){
        return  userService.getUsers();
    }
    @GetMapping("/{userID}")
    UserResponse getUser(@PathVariable String userID) {
        return userService.getUser(userID);
    }

    @PutMapping("/{userID}")
    UserResponse updateUser (@PathVariable String userID,  @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userID, request);

    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);

        return "User has been deleted";

    }
}
