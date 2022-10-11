package com.example.NewsApplicationAccount.entity;

import com.example.NewsApplicationAccount.repository.table.AccountTable;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Account {
    @NotNull
    private final String email;
    @NotNull
    private final String url;
    private final boolean bookmark;
    private final boolean fav;
    private final boolean like;

    public AccountTable toAccountTable() {
        return new AccountTable(this.email, this.url, false, false, false);
    }
}
