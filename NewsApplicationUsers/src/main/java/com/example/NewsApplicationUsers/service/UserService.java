package com.example.NewsApplicationUsers.service;

import com.example.NewsApplicationUsers.entity.Users;
import com.example.NewsApplicationUsers.exception.ValidationException;
import com.example.NewsApplicationUsers.repository.UserRepository;
import com.example.NewsApplicationUsers.repository.table.UsersTable;
import com.example.NewsApplicationUsers.response.ResultInfoConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public Long createUser(Users users) {
        if (userRepository.findByEmailId(users.getEmailId()).isPresent())
            throw new ValidationException(ResultInfoConstants.DUPLICATE_USER);
        UsersTable usersTable = users.toUsersTable(passwordEncoder);
        userRepository.save(usersTable);
        return usersTable.getId();
    }

    public void changePassword(String password, String emailId) {
        if (!userRepository.findByEmailId(emailId).isPresent())
            throw new ValidationException(ResultInfoConstants.INVALID_USER);
        UsersTable usersTable = userRepository.findByEmailId(emailId).get();
        usersTable.setPassword(password);
        userRepository.save(usersTable);
    }

}
