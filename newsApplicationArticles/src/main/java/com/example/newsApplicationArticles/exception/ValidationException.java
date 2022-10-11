package com.example.newsApplicationArticles.exception;


import com.example.newsApplicationArticles.response.ResultInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationException extends RuntimeException {
    private ResultInfo resultInfo;
}
