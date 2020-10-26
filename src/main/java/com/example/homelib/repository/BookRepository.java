package com.example.homelib.repository;

import com.example.homelib.repository.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository  {

    Long create(Book book);

    void update(Long id, Book book);

    Optional<Book> findById(Long id);

    List<Book> findAll();

    void delete(Long id);

}
