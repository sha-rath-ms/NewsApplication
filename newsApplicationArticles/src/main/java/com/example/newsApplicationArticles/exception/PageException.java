package com.example.newsApplicationArticles.exception;

import com.example.newsApplicationArticles.response.ResultInfo;
import lombok.Data;

@Data
public class PageException extends RuntimeException{
    private final ResultInfo resultInfo;
}
