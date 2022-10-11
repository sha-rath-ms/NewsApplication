package com.example.NewsApplicationUsers.service;

import com.example.NewsApplicationUsers.entity.Article;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "article-ws")
public interface ArticleService {

    @GetMapping("/article-ws/home")
    String home();

    @GetMapping("/article-ws/article")
    String getArticle(@RequestHeader("url") String url);

    @GetMapping("/article-ws/headlines")
    String getHeadlines(@RequestParam("sources") String sources, @RequestParam("q") String q, @RequestParam("country") String country, @RequestParam("category") String category, @RequestParam(value = "page", defaultValue = "1") String page);

    @GetMapping("/article-ws/everything")
    String getEverything(@RequestParam("sources") String sources, @RequestParam("q") String q, @RequestParam("country") String country, @RequestParam("category") String category, @RequestParam(value = "page", defaultValue = "1") String page);
}
