package com.example.fitnesstrainer.service;

import com.example.fitnesstrainer.entity.EmailItem;
import com.example.fitnesstrainer.repository.EmailItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmailItemService {

    private final EmailItemRepository emailItemRepository;

    @Autowired
    public EmailItemService(EmailItemRepository repository, EmailItemRepository emailItemRepository) {
        this.emailItemRepository = emailItemRepository;
    }

    public EmailItem findByEmail(String email) {
        return emailItemRepository.findByEmail(email);
    }

    public Optional<EmailItem> findById(Long id) {
        return emailItemRepository.findById(id);
    }

    public EmailItem saveEmailItem(EmailItem emailItem) {
        return emailItemRepository.save(emailItem);
    }
    public void deleteEmployeeById(Long id) {
        emailItemRepository.deleteById(id);
    }
}
