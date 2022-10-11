package com.example.newsApplicationArticles.exception;

import com.example.newsApplicationArticles.response.ResponseWrapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseWrapper handleValidationException(ValidationException validationException) {
        return new ResponseWrapper(validationException.getResultInfo(), null);
    }

    @ExceptionHandler(PageException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseWrapper handleValidationException(PageException pageException) {
        return new ResponseWrapper(pageException.getResultInfo(), null);
    }

}
