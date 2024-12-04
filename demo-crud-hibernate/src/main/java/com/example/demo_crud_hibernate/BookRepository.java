package com.example.demo_crud_hibernate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT * FROM Book", nativeQuery = true)
    List<Book> findAll();
}
