package com.example.NewsApplicationUsers.controllers;

import com.example.NewsApplicationUsers.entity.Account;
import com.example.NewsApplicationUsers.security.JwtTokenUtil;
import com.example.NewsApplicationUsers.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    private final JwtTokenUtil jwtTokenUtil;

    @PostMapping("/bookmark")
    @ResponseStatus(HttpStatus.OK)
    public Account bookmark(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestHeader("url") String url) {
        return accountService.bookmark(new Account(jwtTokenUtil.getUsernameFromToken(token), url));
    }

    @PostMapping("/like")
    @ResponseStatus(HttpStatus.OK)
    public Account like(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestHeader("url") String url) {
        return accountService.like(new Account(jwtTokenUtil.getUsernameFromToken(token), url));
    }

    @PostMapping("/fav")
    @ResponseStatus(HttpStatus.OK)
    public Account fav(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestHeader("url") String url) {
        return accountService.fav(new Account(jwtTokenUtil.getUsernameFromToken(token), url));
    }
}
