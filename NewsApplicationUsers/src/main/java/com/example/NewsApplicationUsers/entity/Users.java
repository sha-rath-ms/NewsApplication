package com.example.NewsApplicationUsers.entity;

import com.example.NewsApplicationUsers.repository.table.UsersTable;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Users {
    @NotNull
    private final String firstName;
    @NotNull
    private final String lastName;
    @NotNull
    @Size(min = 4)
    private final String password;
    @NotNull
    private final String emailId;

    public UsersTable toUsersTable(PasswordEncoder passwordEncoder) {
        return new UsersTable(this.firstName, this.lastName, passwordEncoder.encode(this.password), this.emailId);
    }
}
