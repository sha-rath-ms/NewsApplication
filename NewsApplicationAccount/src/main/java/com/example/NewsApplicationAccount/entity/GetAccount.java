package com.example.NewsApplicationAccount.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GetAccount {
    @NotNull
    private final String email;
    @NotNull
    private final String url;
}
