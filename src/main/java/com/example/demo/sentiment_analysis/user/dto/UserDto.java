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

    @NotBlank(message = "Username must not be blank")
    @Pattern(
            regexp = "^[a-zA-Z]+(?: [a-zA-Z]+)*(?:[0-9]+)?$",
            message = "Username must contain a valid name with optional numbers"
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