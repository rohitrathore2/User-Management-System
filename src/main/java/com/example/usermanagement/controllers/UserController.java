package com.example.usermanagement.controllers;

import com.example.usermanagement.dto.UserRequestDTO;
import com.example.usermanagement.dto.UserResponseDTO;
import com.example.usermanagement.models.User;
import com.example.usermanagement.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;
    // constructor injection
    public UserController(UserService userService){
        this.userService = userService;
    }

    // get all users
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        //return ResponseEntity.ok(userService.getAllUsers());
        List<UserResponseDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }


    // get user by id
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id){
        //return ResponseEntity.ok(userService.getUserById(id));
        UserResponseDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    // create user
    // now using UserRequestDTO instead of user
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
       // return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
        UserResponseDTO createdUser = userService.createUser(userRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    // update user
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UserRequestDTO requestDTO){
       // return ResponseEntity.ok(userService.updateUser(id, user));
        UserResponseDTO updatedUser = userService.updateUser(id, requestDTO);
        return ResponseEntity.ok(updatedUser);
    }

    // delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
