package com.example.NewsApplicationAccount.repository;

import com.example.NewsApplicationAccount.repository.table.LastPageTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LastPageRepository extends JpaRepository<LastPageTable, String> {
}
