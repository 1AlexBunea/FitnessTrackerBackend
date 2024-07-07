package com.example.fitnesstrainer.entity;

import com.example.fitnesstrainer.post.ListItem;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

@Entity
public class EmailItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ListItem> items;

    // Constructors, getters, setters, etc.

    public EmailItem() {
        // Default constructor
    }

    public EmailItem(String email, String password) {
        this.email = email;
        this.password = password;
        this.items = new ArrayList<>();
    }

    public EmailItem(String emailId, List<ListItem> items) {
        this.email = emailId;
        this.items = items;
    }

    public void addItems(ListItem item) {
        items.add(item);
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ListItem> getItems() {
        return this.items;
    }

    public void setItems(List<ListItem> items) {
        this.items = items;
    }

}
