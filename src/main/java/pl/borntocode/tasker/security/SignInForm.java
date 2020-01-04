package pl.borntocode.tasker.security;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class SignInForm {

    private String username;
    private String password;
    private Timestamp lastLogged;
}
