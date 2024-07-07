package com.example.fitnesstrainer.repository;

import com.example.fitnesstrainer.entity.EmailItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailItemRepository extends JpaRepository<EmailItem, Long> {
    // You can define custom query methods here if needed
    EmailItem findByEmail(String email);
}
