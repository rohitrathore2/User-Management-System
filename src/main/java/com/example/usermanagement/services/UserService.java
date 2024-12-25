package com.example.usermanagement.services;

import com.example.usermanagement.dto.UserRequestDTO;
import com.example.usermanagement.dto.UserResponseDTO;
import com.example.usermanagement.exceptions.UserNotFoundException;
import com.example.usermanagement.models.User;
import com.example.usermanagement.repositories.UserRepository;
import com.example.usermanagement.utility.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        // constructor injection
        this.userRepository = userRepository;
    }

    // crud operations

    // 1. Create User
//    public User createUser(User user){
//        return userRepository.save(user);
//    }
    // 1. Create User with dto
    public UserResponseDTO createUser(UserRequestDTO requestDTO){
        User user = UserMapper.toEntity(requestDTO);    // 1. convert UserRequestDTO to User Entity
        User savedUser = userRepository.save(user);     // 2. save the entity
        return UserMapper.toDTO(savedUser);             // 3. convert User Entity to UserResponseDTO and return it.
    }

    // 2. Get User by id
//    public User getUserById(Long id){
//        return userRepository.findById(id)
//                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
//    }
    // 2. Get User by id with dto
    public UserResponseDTO getUserById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        return UserMapper.toDTO(user);      // convert User to UserResponseDTO
    }

    // 3. Get all Users
//    public List<User> getAllUsers(){
//        return userRepository.findAll();
//    }
    // 3. Get all Users with dto
    public List<UserResponseDTO> getAllUsers(){
        return userRepository.findAll().stream().map(UserMapper :: toDTO).collect(Collectors.toList());
    }

    // 4. Update User
//    public User updateUser(Long id, User userDetails){
//        User user = getUserById(id);
//        user.setUsername(userDetails.getUsername());
//        user.setEmail(userDetails.getEmail());
//        return userRepository.save(user);
//    }
    // 4. Update User with dto
    public UserResponseDTO updateUser(Long id, UserRequestDTO requestDTO){
        User existingUser = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User not found with id: " + id));
        existingUser.setUsername(requestDTO.getUsername());
        existingUser.setEmail(requestDTO.getEmail());
        if(requestDTO.getPassword() != null){
            existingUser.setPassword(requestDTO.getPassword());
        }
        User updatedUser = userRepository.save(existingUser);
        return UserMapper.toDTO(updatedUser);
    }

    // 5. Delete User
//    public void deleteUser(Long id){
//        userRepository.deleteById(id);
//    }
    // 5. Delete User with dto
    public void deleteUser(Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }
}
