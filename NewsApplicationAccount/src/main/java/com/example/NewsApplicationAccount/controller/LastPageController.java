package com.example.NewsApplicationAccount.controller;

import com.example.NewsApplicationAccount.entity.LastPage;
import com.example.NewsApplicationAccount.service.LastPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account-ws")
@RequiredArgsConstructor
public class LastPageController {

    private final LastPageService lastPageService;

    @PostMapping("/last-page")
    @ResponseStatus(HttpStatus.OK)
    public LastPage getLastPage(@RequestBody String email)
    {
        return lastPageService.getLastPage(email);
    }

    @PostMapping("/last-page/insert")
    @ResponseStatus(HttpStatus.OK)
    public void insertLastPage(@RequestBody LastPage lastPage)
    {
        lastPageService.insertLastPage(lastPage);
    }

    @DeleteMapping("/last-page/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteLastPage(@RequestBody String email)
    {
        lastPageService.deleteLastPage(email);
    }
}
