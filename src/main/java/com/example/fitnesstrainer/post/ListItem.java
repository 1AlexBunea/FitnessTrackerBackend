package com.example.fitnesstrainer.post;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class ListItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int day;
    private int month;
    private int year;
    private String description;

    // Constructors, getters, setters, etc.

    public ListItem() {
        // Default constructor
    }

    public ListItem(int value1, int value2, int value3, String description) {
        this.day = value1;
        this.month = value2;
        this.year = value3;
        this.description = description;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int value2) {
        this.month = value2;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int value3) {
        this.year = value3;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
