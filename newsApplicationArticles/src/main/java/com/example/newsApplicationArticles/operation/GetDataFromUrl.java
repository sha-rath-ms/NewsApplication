package com.example.newsApplicationArticles.operation;

import com.example.newsApplicationArticles.exception.PageException;
import com.example.newsApplicationArticles.response.ResultInfoConstants;
import org.springframework.web.client.RestTemplate;

public class GetDataFromUrl {

    public static String getData(String url) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(url, String.class);
        } catch (Exception e) {
            throw new PageException(ResultInfoConstants.INVALID_SITE);
        }
    }
}
