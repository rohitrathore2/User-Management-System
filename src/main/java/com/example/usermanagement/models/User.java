package com.example.usermanagement.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Data
@Entity // mark this class as jpa entity
@Table(name = "users")
public class User {
    @Id // mark this field as primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto incremented id values
    private Long id;

    @NotBlank(message = "Username is required")
    @Size(min = 3, message = "Username must be atleast 3 characters long")
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be 6 characters long")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z]).*$", message = "Password must contain both letters and numbers")
    private String password;

    public User(){
        // default constructor : jpa require default constructor
    }

    // getters
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
