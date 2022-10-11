package com.example.NewsApplicationAccount.service;

import com.example.NewsApplicationAccount.entity.LastPage;
import com.example.NewsApplicationAccount.repository.LastPageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LastPageService {

    private final LastPageRepository lastPageRepository;

    public void insertLastPage(LastPage lastPage) {
        lastPageRepository.save(lastPage.toLastPageTable());
    }

    public LastPage getLastPage(String email) {
        if (!lastPageRepository.findById(email).isPresent())
            return null;
        return lastPageRepository.getById(email).toLastPage();
    }

    public void deleteLastPage(String email) {
        if (!lastPageRepository.findById(email).isPresent())
            lastPageRepository.deleteById(email);
    }
}
