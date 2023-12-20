package com.example.GenerativeAI0201.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private GenreName genreName;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
    private Set<Book> books;
}

