package com.example.demo_crud_hibernate;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Create a new book
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // Retrieve all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Retrieve a book by ID
    public Optional<Book> getBookById(int id) {
        return bookRepository.findById((long) id);
    }

    // Update a book
    public Book updateBook(Long id, Book updatedBook) {
        return bookRepository.findById(id)
            .map(existingBook -> {
                existingBook.setAuthor(updatedBook.getAuthor());
                existingBook.setTitle(updatedBook.getTitle());
                existingBook.setPrice(updatedBook.getPrice());
                return bookRepository.save(existingBook);
            })
            .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    // Delete a book by ID
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
