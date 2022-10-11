package com.example.NewsApplicationAccount.repository.table;

import com.example.NewsApplicationAccount.entity.LastPage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "lastpage")
@AllArgsConstructor
@NoArgsConstructor
public class LastPageTable {
    @Id
    private String email;
    private String url;
    private boolean homepage;
    private boolean headlines;
    private boolean everything;
    private String sources;
    private String q;
    private String country;
    private String category;
    private String page;

    public LastPage toLastPage()
    {
        return new LastPage(this.email,this.getUrl(),this.homepage,this.headlines,this.everything,this.sources,this.q,this.country,this.category,this.page);
    }
}
