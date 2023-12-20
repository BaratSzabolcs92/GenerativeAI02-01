package com.example.GenerativeAI0201.repositories;

import com.example.GenerativeAI0201.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByName(String name);
}
