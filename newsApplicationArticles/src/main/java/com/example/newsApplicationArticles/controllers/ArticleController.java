package com.example.newsApplicationArticles.controllers;

import com.example.newsApplicationArticles.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article-ws")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/home")
    @ResponseStatus(HttpStatus.OK)
    public String home()
    {
        return articleService.homepage();
    }

    @GetMapping("/article")
    @ResponseStatus(HttpStatus.OK)
    public String getArticle(@RequestHeader("url") String url)
    {
        return articleService.getArticle(url);
    }

    @GetMapping("/headlines")
    @ResponseStatus(HttpStatus.OK)
    public String headlines(@RequestParam(value = "sources",required = false) String sources, @RequestParam(value = "q",required = false) String q, @RequestParam(value = "country",required = false) String country, @RequestParam(value = "category",required = false) String category, @RequestParam(value = "page", defaultValue = "1") String page)
    {
        return articleService.getHeadlines(sources,q,category,country,page);
    }

    @GetMapping("/everything")
    @ResponseStatus(HttpStatus.OK)
    public String everything(@RequestParam(value = "sources",required = false) String sources, @RequestParam(value = "q",required = false) String q, @RequestParam(value = "country",required = false) String country, @RequestParam(value = "category",required = false) String category, @RequestParam(value = "page", defaultValue = "1") String page)
    {
        return articleService.getEverything(sources,q,category,country,page);
    }
}
