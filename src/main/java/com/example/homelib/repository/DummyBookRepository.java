package com.example.homelib.repository;

import com.example.homelib.repository.model.Book;

import java.util.List;
import java.util.Optional;

public class DummyBookRepository implements BookRepository{
    @Override
    public Long create(Book book) {
        return null;
    }

    @Override
    public void update(Long id, Book book) {

    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
