package com.example.fitnesstrainer.controller;

import com.example.fitnesstrainer.entity.EmailItem;
import com.example.fitnesstrainer.service.EmailItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

@RestController
@RequestMapping
public class EmailItemController {

    private final EmailItemService emailItemService;

    @Autowired
    public EmailItemController(EmailItemService service, EmailItemService emailItemService) {
        this.emailItemService = service;
    }

    @PostMapping("/add")
    public ResponseEntity<String> createEmailItem(@RequestBody EmailItem emailItem) {
        EmailItem existingEmailItem = emailItemService.findByEmail(emailItem.getEmail());
        if (existingEmailItem != null) { // if the person exists already
            emailItemService.deleteEmployeeById(existingEmailItem.getId());
            existingEmailItem.setItems(emailItem.getItems());
            emailItemService.saveEmailItem(existingEmailItem);
            return ResponseEntity.badRequest().body("Updating email");
        }
        emailItemService.saveEmailItem(emailItem);
        return ResponseEntity.ok("Email item created successfully.");
    }

    // returns
    @GetMapping("/login/{email}/{password}")
    public ResponseEntity<EmailItem> getEmailItemByEmail(@PathVariable String email, @PathVariable String password) {
        EmailItem existingPerson = emailItemService.findByEmail(email);
        if (existingPerson == null) {
            return ResponseEntity.notFound().build();
        }
        if (!existingPerson.getPassword().equals(password)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(existingPerson);
    }

//    @GetMapping("/{id}/{password}")
//    public ResponseEntity<EmailItem> getEmailItemById(@PathVariable Long id, @PathVariable String password) {
//        Optional<EmailItem> person = emailItemService.findById(id);
//        if (person.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        if (!person.get().getPassword().equals(password)) {
//            return ResponseEntity.badRequest().build();
//        }
//        emailItemService.deleteEmployeeById(id);
//        return ResponseEntity.ok(person.get());
//    }

//    @DeleteMapping("/id/{id}/{password}")
//    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id, @PathVariable String password) {
//        Optional<EmailItem> person = emailItemService.findById(id);
//        if (person.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        if (!person.get().getPassword().equals(password)) {
//            return ResponseEntity.badRequest().build();
//        }
//        emailItemService.deleteEmployeeById(id);
//        return ResponseEntity.ok("Employee deleted successfully.");
//    }

    @DeleteMapping("/delete/{email}/{password}")
    public ResponseEntity<String> deleteEmployeeByEmail(@PathVariable String email, @PathVariable String password) {
        EmailItem person = emailItemService.findByEmail(email);
        if (person == null) {
            return ResponseEntity.notFound().build();
        }
        if (!person.getPassword().equals(password)) {
            return ResponseEntity.badRequest().build();
        }
        emailItemService.deleteEmployeeById(person.getId());
        return ResponseEntity.ok("Employee deleted successfully.");
    }
}

