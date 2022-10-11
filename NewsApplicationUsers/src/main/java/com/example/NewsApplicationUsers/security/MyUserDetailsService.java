package com.example.NewsApplicationUsers.security;

import com.example.NewsApplicationUsers.exception.ValidationException;
import com.example.NewsApplicationUsers.repository.UserRepository;
import com.example.NewsApplicationUsers.repository.table.UsersTable;
import com.example.NewsApplicationUsers.response.ResultInfoConstants;
import com.example.NewsApplicationUsers.service.UserService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@Data
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsersTable> users = userRepository.findByEmailId(username);
        if (!users.isPresent()) {
            log.warn("User is not found");
            throw new ValidationException(ResultInfoConstants.INVALID_USER);
        }
        return users.map(MyUserDetails::new).get();
    }
}
