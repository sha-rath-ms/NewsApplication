package com.example.NewsApplicationUsers.repository;

import com.example.NewsApplicationUsers.repository.table.UsersTable;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UsersTable,Long> {
    Optional<UsersTable> findByEmailId(String email);

    @NotNull Optional<UsersTable> findById(Long id);
}
