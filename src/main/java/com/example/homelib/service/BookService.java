package com.example.homelib.service;

import com.example.homelib.repository.model.Book;
import com.example.homelib.repository.model.User;

import java.util.List;
import java.util.Optional;

public class BookService {

    public List<Book> findAll() {
        return null;
    };

    void create(Book book ){};

    void update(Book book ){};

    void deleteById(Long id){};

    List<User> findUserByBookId(Long id){
        return null;
    };

    Optional<Book> getById(Long id){
        return null;
    };

    void assign(Integer id, Integer participantId){};
}
