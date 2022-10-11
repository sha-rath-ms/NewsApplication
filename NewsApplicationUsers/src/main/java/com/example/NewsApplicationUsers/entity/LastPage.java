package com.example.NewsApplicationUsers.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LastPage {
    private final String email;
    private String url;
    private boolean homepage;
    private boolean headlines;
    private boolean everything;
    private String sources;
    private String q;
    private String country;
    private String category;
    private String page;
}
