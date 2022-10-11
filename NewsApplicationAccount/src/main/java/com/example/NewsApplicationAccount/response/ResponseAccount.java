package com.example.NewsApplicationAccount.response;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ResponseAccount {
    @NotNull
    private final String url;
    @NotNull
    private final boolean bookmark;
    @NotNull
    private final boolean fav;
    @NotNull
    private final boolean like;
}
