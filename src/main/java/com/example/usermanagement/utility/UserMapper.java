package com.example.usermanagement.utility;

import com.example.usermanagement.dto.UserRequestDTO;
import com.example.usermanagement.dto.UserResponseDTO;
import com.example.usermanagement.models.User;

public class UserMapper {
    // convert User Entity to UserResponseDTO
    public static UserResponseDTO toDTO(User user){
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        return dto;
    }

    // convert UserRequestDTO to User Entity
    public static User toEntity(UserRequestDTO dto){
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }
}
