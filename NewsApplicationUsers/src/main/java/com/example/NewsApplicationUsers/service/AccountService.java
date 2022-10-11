package com.example.NewsApplicationUsers.service;

import com.example.NewsApplicationUsers.entity.Account;
import com.example.NewsApplicationUsers.entity.LastPage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "account-ws")
public interface AccountService {

    @DeleteMapping("/last-page/delete")
    void deleteLastPage(@RequestBody String email);

    @PostMapping("/account-ws/read")
    Account read(@RequestBody Account account);

    @PostMapping("/account-ws/bookmark")
    Account bookmark(@RequestBody Account account);

    @PostMapping("/account-ws/like")
    Account like(@RequestBody Account account);

    @PostMapping("/account-ws/fav")
    Account fav(@RequestBody Account account);

    @PostMapping("/account-ws/last-page/insert")
    void insertLastPage(LastPage lastPage);

    @GetMapping("/account-ws/last-page")
    LastPage lastPage(@RequestBody String email);

    @GetMapping("/account-ws")
    Account get(@RequestBody Account account);
}
