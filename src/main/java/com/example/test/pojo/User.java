package com.example.test.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @NotBlank(message = "username cannot be null")
    private String userName;
    @NotBlank(message = "password cannot be null")
    private String password;
    @NotBlank(message = "role cannot be blank")
    private String role;

}
