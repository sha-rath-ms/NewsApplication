package com.example.NewsApplicationUsers.controllers;


import com.example.NewsApplicationUsers.entity.Account;
import com.example.NewsApplicationUsers.entity.LastPage;
import com.example.NewsApplicationUsers.entity.Users;
import com.example.NewsApplicationUsers.response.ResponseAccountAndArticle;
import com.example.NewsApplicationUsers.response.ResponseWrapper;
import com.example.NewsApplicationUsers.response.ResultInfoConstants;
import com.example.NewsApplicationUsers.security.JwtTokenUtil;
import com.example.NewsApplicationUsers.service.AccountService;
import com.example.NewsApplicationUsers.service.ArticleService;
import com.example.NewsApplicationUsers.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final JwtTokenUtil jwtTokenUtil;

    private final ArticleService articleService;

    private final AccountService accountService;

    @PostMapping("/signUp")
    @ResponseStatus(HttpStatus.OK)
    public Long signUp(@RequestBody @Valid Users users) {
        return userService.createUser(users);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/home")
    public ResponseWrapper home(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        accountService.insertLastPage(new LastPage(jwtTokenUtil.getUsernameFromToken(token), null, true, false, false, null, null, null, null, null));
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, articleService.home());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/article")
    public ResponseWrapper<ResponseAccountAndArticle> getArticle(@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
                                                                 @RequestHeader("url") String url) {
        Account account = new Account(jwtTokenUtil.getUsernameFromToken(token), url);
        accountService.insertLastPage(new LastPage(jwtTokenUtil.getUsernameFromToken(token), url, false, false, false, null, null, null, null, null));
        return new ResponseWrapper<ResponseAccountAndArticle>(ResultInfoConstants.SUCCESS
                , new ResponseAccountAndArticle(accountService.read(account), articleService.getArticle(url)));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public ResponseWrapper get(@RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        LastPage lastPage = accountService.lastPage(jwtTokenUtil.getUsernameFromToken(token));
        if (lastPage.getUrl() != null) {
            Account account = new Account(jwtTokenUtil.getUsernameFromToken(token), lastPage.getUrl());
            return new ResponseWrapper<ResponseAccountAndArticle>(ResultInfoConstants.SUCCESS, new ResponseAccountAndArticle(accountService.get(account), articleService.getArticle(lastPage.getUrl())));
        } else if (lastPage.isEverything())
            return new ResponseWrapper<>(ResultInfoConstants.SUCCESS, articleService.getEverything(lastPage.getSources(), lastPage.getQ(), lastPage.getCountry(), lastPage.getCategory(), lastPage.getPage()));
        else if (lastPage.isHeadlines())
            return new ResponseWrapper<>(ResultInfoConstants.SUCCESS, articleService.getHeadlines(lastPage.getSources(), lastPage.getQ(), lastPage.getCountry(), lastPage.getCategory(), lastPage.getPage()));
        else
            return new ResponseWrapper(ResultInfoConstants.SUCCESS, articleService.home());
    }

    @GetMapping("/headlines")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper getHeadlines(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestParam(value = "sources", required = false) String sources, @RequestParam(value = "q", required = false) String q, @RequestParam(value = "country", required = false) String country, @RequestParam(value = "category", required = false) String category, @RequestParam(value = "page", defaultValue = "1") String page) {
        accountService.insertLastPage(new LastPage(jwtTokenUtil.getUsernameFromToken(token), null, false, true, false, sources, q, country, category, page));
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, articleService.getHeadlines(sources, q, country, category, page));
    }

    @GetMapping("/everything")
    @ResponseStatus(HttpStatus.OK)
    public ResponseWrapper getEverything(@RequestHeader(HttpHeaders.AUTHORIZATION) String token, @RequestParam(value = "sources", required = false) String sources, @RequestParam(value = "q", required = false) String q, @RequestParam(value = "country", required = false) String country, @RequestParam(value = "category", required = false) String category, @RequestParam(value = "page", defaultValue = "1") String page) {
        accountService.insertLastPage(new LastPage(jwtTokenUtil.getUsernameFromToken(token), null, false, false, true, sources, q, country, category, page));
        return new ResponseWrapper(ResultInfoConstants.SUCCESS, articleService.getEverything(sources, q, country, category, page));
    }
}
