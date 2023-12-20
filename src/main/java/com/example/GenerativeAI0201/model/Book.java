package com.example.GenerativeAI0201.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Genre genre;
    private double price;
    private int quantity;

    // getters and setters...
}
