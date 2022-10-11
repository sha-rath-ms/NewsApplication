package com.example.NewsApplicationUsers.entity;

import lombok.Data;

@Data
public class Account {
    private String email;
    private String url;
    private boolean bookmark;
    private boolean fav;
    private boolean like;

    public Account(String email, String url) {
        this.email = email;
        this.url = url;
    }
}
