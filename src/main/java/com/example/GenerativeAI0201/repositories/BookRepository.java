package com.example.GenerativeAI0201.repositories;

import com.example.GenerativeAI0201.model.Author;
import com.example.GenerativeAI0201.model.Book;
import com.example.GenerativeAI0201.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    // Already have methods like save(), findById(), delete(), findAll() etc.
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(Author author);
    List<Book> findByGenre(Genre genre);
}
