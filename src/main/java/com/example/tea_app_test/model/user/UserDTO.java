package com.example.tea_app_test.model.user;

import com.example.tea_app_test.utils.PasswordMatches;
import com.example.tea_app_test.utils.ValidEmail;
import com.example.tea_app_test.utils.ValidPassword;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatches
@ToString
public class UserDTO {
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

    private Set<Role> role = Set.of(Role.ROLE_USER);

    @NotNull
    @NotEmpty
    @ValidPassword
    private String password;

    @NotNull
    @NotEmpty
    private String matchingPassword;
}