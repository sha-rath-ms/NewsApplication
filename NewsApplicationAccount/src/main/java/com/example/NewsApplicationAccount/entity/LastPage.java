package com.example.NewsApplicationAccount.entity;

import com.example.NewsApplicationAccount.repository.table.LastPageTable;
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

    public LastPageTable toLastPageTable()
    {
        return new LastPageTable(this.email,this.url,this.homepage,this.headlines,this.everything,this.sources,this.q,this.country,this.category,this.page);
    }
}
