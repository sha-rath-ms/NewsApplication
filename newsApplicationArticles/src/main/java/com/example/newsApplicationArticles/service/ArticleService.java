package com.example.newsApplicationArticles.service;

import com.example.newsApplicationArticles.operation.GetParamsForApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.newsApplicationArticles.operation.GetDataFromUrl.getData;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private String newsEverything = "https://newsapi.org/v2/everything";

    private String newsHeadlines = "https://newsapi.org/v2/top-headlines";

    private String apiKey = "9310c0780de94a6ebc9e3018701bffaf";

    public String getArticle(String url) {
        return getData(url);
    }

    public String homepage() {
        return getData(newsHeadlines + "/sources?&apiKey=" + apiKey);
    }

    public String getEverything(String sources, String q, String category, String country, String page) {
        GetParamsForApi getParamsForApi = new GetParamsForApi(sources, q, country, category, page);
        return getData(newsEverything + "?" + getParamsForApi.getParams().substring(1) + "&apiKey=" + apiKey);
    }

    public String getHeadlines(String sources, String q, String category, String country, String page) {
        GetParamsForApi getParamsForApi = new GetParamsForApi(sources, q, country, category, page);
        return getData(newsHeadlines + "?" + getParamsForApi.getParams().substring(1) + "&apiKey=" + apiKey);
    }

}
