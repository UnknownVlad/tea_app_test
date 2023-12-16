package com.example.tea_app_test.model.user;

import com.example.tea_app_test.utils.PasswordMatches;
import com.example.tea_app_test.utils.ValidEmail;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatches
@ToString
public class UserDto {
    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String surname;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String matchingPassword;

}