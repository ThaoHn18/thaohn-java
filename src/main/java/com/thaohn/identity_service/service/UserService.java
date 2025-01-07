package com.thaohn.identity_service.service;

import com.thaohn.identity_service.dto.request.UserCreationRequest;
import com.thaohn.identity_service.dto.request.UserUpdateRequest;
import com.thaohn.identity_service.dto.response.UserResponse;
import com.thaohn.identity_service.entity.User;
import com.thaohn.identity_service.exception.AppException;
import com.thaohn.identity_service.exception.ErrorCode;
import com.thaohn.identity_service.mapper.UserMapper;
import com.thaohn.identity_service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private UserMapper userMapper;
//    Nho co @RequiredArgsConstructor  @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)  nen viet ngan gon nhu duoi

    UserRepository userRepository;
    UserMapper userMapper;

    public User createUser(UserCreationRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        User user = userMapper.toUser(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return userRepository.save(user);
    }

    public UserResponse updateUser(String userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        userMapper.updateUser(user, request);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public UserResponse getUser(String id) {
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")));
    }

    public void deleteUser (String id) {
        userRepository.deleteById(id);

    }
}
