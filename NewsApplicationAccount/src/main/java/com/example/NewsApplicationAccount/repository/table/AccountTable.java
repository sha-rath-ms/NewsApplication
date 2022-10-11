package com.example.NewsApplicationAccount.repository.table;

import com.example.NewsApplicationAccount.entity.Account;
import com.example.NewsApplicationAccount.response.ResponseAccount;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "account")
@NoArgsConstructor
public class AccountTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String url;
    private boolean bookmark;
    private boolean fav;
    @Column(name = "likes")
    private boolean like;

    public AccountTable(String email, String url, boolean bookmark, boolean fav, boolean like) {
        this.email = email;
        this.url = url;
        this.bookmark = bookmark;
        this.fav = fav;
        this.like = like;
    }

    public Account toAccount()
    {
        return new Account(this.email,this.url,this.bookmark,this.fav,this.like);
    }

    public ResponseAccount toResponseAccount()
    {
        return new ResponseAccount(this.url,this.bookmark,this.fav,this.like);
    }
}
