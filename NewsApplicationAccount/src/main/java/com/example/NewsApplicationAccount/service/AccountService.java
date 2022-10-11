package com.example.NewsApplicationAccount.service;

import com.example.NewsApplicationAccount.entity.Account;
import com.example.NewsApplicationAccount.exception.ValidationException;
import com.example.NewsApplicationAccount.repository.AccountRepository;
import com.example.NewsApplicationAccount.repository.table.AccountTable;
import com.example.NewsApplicationAccount.response.ResponseAccount;
import com.example.NewsApplicationAccount.response.ResultInfoConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.NewsApplicationAccount.operation.SetValues.set;


@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account read(Account account) {
        Optional<AccountTable> oldAccount = accountRepository.findByEmailAndUrl(account.getEmail(), account.getUrl());
        if (!oldAccount.isPresent()) {
            accountRepository.save(account.toAccountTable());
            return account;
        }
        return oldAccount.get().toAccount();
    }

    public Account bookmark(Account account) {
        Optional<AccountTable> oldAccount = accountRepository.findByEmailAndUrl(account.getEmail(), account.getUrl());
        if (!oldAccount.isPresent()) {
            AccountTable accountTable = account.toAccountTable();
            accountTable.setBookmark(set(accountTable.isBookmark()));
            accountRepository.save(accountTable);
            return accountTable.toAccount();
        }
        AccountTable accountTable = oldAccount.get();
        accountTable.setBookmark(set(accountTable.isBookmark()));
        accountRepository.save(accountTable);
        return accountTable.toAccount();
    }

    public Account fav(Account account) {
        Optional<AccountTable> oldAccount = accountRepository.findByEmailAndUrl(account.getEmail(), account.getUrl());
        if (!oldAccount.isPresent()) {
            AccountTable accountTable = account.toAccountTable();
            accountTable.setFav(set(accountTable.isFav()));
            accountRepository.save(accountTable);
            return accountTable.toAccount();
        }
        AccountTable accountTable = oldAccount.get();
        accountTable.setFav(set(accountTable.isFav()));
        accountRepository.save(accountTable);
        return accountTable.toAccount();
    }

    public Account like(Account account) {
        Optional<AccountTable> oldAccount = accountRepository.findByEmailAndUrl(account.getEmail(), account.getUrl());
        if (!oldAccount.isPresent()) {
            AccountTable accountTable = account.toAccountTable();
            accountTable.setLike(set(accountTable.isLike()));
            accountRepository.save(accountTable);
            return accountTable.toAccount();
        }
        AccountTable accountTable = oldAccount.get();
        accountTable.setLike(set(accountTable.isLike()));
        accountRepository.save(accountTable);
        return accountTable.toAccount();
    }

    public List<ResponseAccount> home(String emailId) {
        if (accountRepository.findByEmail(emailId).isEmpty())
            throw new ValidationException(ResultInfoConstants.INVALID_USER);
        return accountRepository.findByEmail(emailId).stream().map(AccountTable::toResponseAccount).collect(Collectors.toList());
    }

    public List<ResponseAccount> getBookmark(String emailId) {
        if (accountRepository.findByEmail(emailId).isEmpty())
            throw new ValidationException(ResultInfoConstants.INVALID_USER);
        return accountRepository.findByEmailAndBookmark(emailId, true).stream().map(AccountTable::toResponseAccount).collect(Collectors.toList());
    }

    public List<ResponseAccount> getLike(String emailId) {
        if (accountRepository.findByEmail(emailId).isEmpty())
            throw new ValidationException(ResultInfoConstants.INVALID_USER);
        return accountRepository.findByEmailAndLike(emailId, true).stream().map(AccountTable::toResponseAccount).collect(Collectors.toList());
    }

    public List<ResponseAccount> getFav(String emailId) {
        if (accountRepository.findByEmail(emailId).isEmpty())
            throw new ValidationException(ResultInfoConstants.INVALID_USER);
        return accountRepository.findByEmailAndFav(emailId, true).stream().map(AccountTable::toResponseAccount).collect(Collectors.toList());
    }

    public Account get(Account account) {
        if (accountRepository.findByEmail(account.getEmail()).isEmpty())
            throw new ValidationException(ResultInfoConstants.INVALID_USER);
        return accountRepository.findByEmailAndUrl(account.getEmail(), account.getUrl()).get().toAccount();
    }
}
