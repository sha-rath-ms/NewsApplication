package com.example.NewsApplicationAccount.exception;

import com.example.NewsApplicationAccount.response.ResultInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationException extends RuntimeException {
    private ResultInfo resultInfo;
}
