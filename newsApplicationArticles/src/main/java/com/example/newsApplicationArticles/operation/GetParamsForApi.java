package com.example.newsApplicationArticles.operation;

import com.example.newsApplicationArticles.exception.ValidationException;
import com.example.newsApplicationArticles.response.ResultInfoConstants;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetParamsForApi {

    private String source;
    private String q;
    private String country;
    private String category;
    private String page;

    public String source()
    {
        if(source==null)
            return "";
        return "&sources="+source;
    }

    public String q()
    {
        if(q==null)
            return "";
        return "&q="+q;
    }

    public String country()
    {
        if(country==null)
            return "";
        return "&country="+country;
    }

    public String category()
    {
        if(category==null)
            return "";
        return "&category="+category;
    }

    public String page()
    {
        return "&page="+page+"&pageSize=10";
    }

    public String getParams()
    {
        return source()+q()+country()+category()+page();
    }
}
