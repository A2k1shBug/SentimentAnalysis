package com.example.demo.sentiment_analysis.user.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    @Pattern(
            regexp = "^[a-zA-Z0-9_]{3,20}$",
            message = "Username must be 3-20 characters and contain only letters, numbers or underscore"
    )
    private String userName;

//    @NotBlank(message = "Email must not be blank")
//    @Email(message = "Invalid email format")
//    @Pattern(
//            regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$",
//            message = "Email must be lowercase"
//    )
//    private String userEmail;

    @NotBlank(message = "Password not blank")
    @Size(min = 6, max = 20)
    private String password;
}