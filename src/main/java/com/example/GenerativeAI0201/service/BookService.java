package com.example.GenerativeAI0201.service;

import com.example.GenerativeAI0201.exception.ResourceNotFoundException;
import com.example.GenerativeAI0201.model.Author;
import com.example.GenerativeAI0201.model.Book;
import com.example.GenerativeAI0201.model.Genre;
import com.example.GenerativeAI0201.model.GenreName;
import com.example.GenerativeAI0201.repositories.AuthorRepository;
import com.example.GenerativeAI0201.repositories.BookRepository;
import com.example.GenerativeAI0201.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Get all books
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    // Get a single book by id
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Book found with id " + id));
    }

    // Add a new book
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // Update an existing book
    public Book updateBook(Long id, Book bookDetails) {
        Book book = getBookById(id);
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setGenre(bookDetails.getGenre());
        book.setPrice(bookDetails.getPrice());
        book.setQuantity(bookDetails.getQuantity());
        return bookRepository.save(book);
    }

    // Delete a book
    public void deleteBook(Long id) {
        Book book = getBookById(id);
        bookRepository.delete(book);
    }

    // Custom findBy methods
    public List<Book> findBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> findBooksByAuthor(Author author) {
        return bookRepository.findByAuthor(author);
    }

    public List<Book> findBooksByGenre(Genre genre) {
        return bookRepository.findByGenre(genre);
    }
    public List<Book> findBooksByAuthorName(String name) {
        Author author = authorRepository.findByName(name);
        return bookRepository.findByAuthor(author);
    }

    public List<Book> findBooksByGenreName(String name) {
        Genre genre = genreRepository.findByGenreName(GenreName.valueOf(name));
        return bookRepository.findByGenre(genre);
    }

}