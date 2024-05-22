package com.example.segundo_parcial.repositories;

import com.example.segundo_parcial.model.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {
}

