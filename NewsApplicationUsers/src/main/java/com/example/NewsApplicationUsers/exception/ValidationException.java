package com.example.NewsApplicationUsers.exception;

import com.example.NewsApplicationUsers.response.ResultInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationException extends RuntimeException {
    private ResultInfo resultInfo;
}
