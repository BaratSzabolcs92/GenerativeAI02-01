package com.example.GenerativeAI0201.repositories;

import com.example.GenerativeAI0201.model.Genre;
import com.example.GenerativeAI0201.model.GenreName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findByGenreName(GenreName genreName);
}