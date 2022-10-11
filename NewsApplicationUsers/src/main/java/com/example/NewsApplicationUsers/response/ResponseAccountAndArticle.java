package com.example.NewsApplicationUsers.response;

import com.example.NewsApplicationUsers.entity.Account;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ResponseAccountAndArticle {
    private final Account account;
    private final String article;
}
