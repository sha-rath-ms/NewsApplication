package com.example.NewsApplicationAccount.controller;

import com.example.NewsApplicationAccount.entity.Account;
import com.example.NewsApplicationAccount.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account-ws")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public Account get(@RequestBody Account account) {
        return accountService.get(account);
    }

    @PostMapping("/read")
    @ResponseStatus(HttpStatus.OK)
    public Account read(@RequestBody Account account) {
        return accountService.read(account);
    }

    @PostMapping("/bookmark")
    @ResponseStatus(HttpStatus.OK)
    public Account bookmark(@RequestBody Account account) {
        return accountService.bookmark(account);
    }

    @PostMapping("/fav")
    @ResponseStatus(HttpStatus.OK)
    public Account fav(@RequestBody Account account) {
        return accountService.fav(account);
    }

    @PostMapping("/like")
    @ResponseStatus(HttpStatus.OK)
    public Account like(@RequestBody Account account) {
        return accountService.like(account);
    }
}
