package com.example.usermanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequestDTO {
    @NotBlank(message = "Username is required")
    @Size(min = 3, message = "Username must be atleast 3 characteres long")
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide valid email")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;


    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
