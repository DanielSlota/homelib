package com.example.homelib.repository.model;
/* ---------------------------------------------------------------------------------------------------------
============================================================================================================
========created_by_Daniel_Słota_a.k.a._Kamien_date:14-10-2020r.=============================================
============================================================================================================
 -----------------------------------------------------------------------------------------------------------*/

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;


@Setter
@Getter
@Builder
@Entity
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false)
    @NotEmpty
    private String name;

    @Column(name = "adress", nullable = false)
    @NotEmpty
    private String adress;

    @Column(name = "owner",nullable = false)
    @NotEmpty
    private User owner;

    @Column(name = "librarians",nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Set<User> librarians;


    @JsonIgnore
    @ManyToMany(mappedBy = "librarys", fetch = FetchType.LAZY)
    private Set<User> users;


    @JsonIgnore
    @OneToMany (fetch = FetchType.LAZY)
    @JoinTable(
            name = "library_book",
            joinColumns = @JoinColumn(name = "library_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> books;





    public void addUser(User user){
        users.add(user);
    }

    public void removeUser(User user){
        users.remove(user);
    }


    public void addLibrarian(User user){
        librarians.add(user);
    }

    public void removeLibrarian(User user){
        librarians.remove(user);
    }



}
