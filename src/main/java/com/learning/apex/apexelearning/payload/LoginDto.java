package com.learning.apex.apexelearning.payload;

import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data
public class LoginDto {
    @NotEmpty
    private String usernameOrEmail;
    @NotEmpty
    private String password;
}
