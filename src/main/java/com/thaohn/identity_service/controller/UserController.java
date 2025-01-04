package com.thaohn.identity_service.controller;

import com.thaohn.identity_service.dto.request.UserCreationRequest;
import com.thaohn.identity_service.dto.request.UserUpdateRequest;
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
    User createUser(@RequestBody @Valid UserCreationRequest request) {
        return userService.createUser(request);
    }

    @GetMapping
    List<User> getUsers(){
        return  userService.getUsers();
    }
    @GetMapping("/{userID}")
    User getUser(@PathVariable String userID) {
        return userService.getUser(userID);
    }

    @PutMapping("/{userID}")
    User updateUser (@PathVariable String userID,  @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userID, request);

    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);

        return "User has been deleted";

    }
}
