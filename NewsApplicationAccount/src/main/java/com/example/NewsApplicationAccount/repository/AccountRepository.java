package com.example.NewsApplicationAccount.repository;

import com.example.NewsApplicationAccount.repository.table.AccountTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountTable, Long> {

    Optional<AccountTable> findByEmailAndUrl(String emailId, String url);

    List<AccountTable> findByEmail(String emailId);

    List<AccountTable> findByEmailAndBookmark(String emailId,boolean value);

    List<AccountTable> findByEmailAndLike(String emailId,boolean value);

    List<AccountTable> findByEmailAndFav(String emailId,boolean value);
}
