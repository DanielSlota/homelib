package com.example.homelib.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.List;

/* ---------------------------------------------------------------------------------------------------------
============================================================================================================
========created_by_Daniel_Słota_a.k.a._Kamien_date:14-10-2020r.=============================================
============================================================================================================
 -----------------------------------------------------------------------------------------------------------*/


@Setter
@Getter
@Builder
@Entity
public class Book {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "ISBN", nullable = false)
    @NotEmpty
    private Long ISBN;

    @Column (name = "title", nullable = false)
    @NotEmpty
    private String title;

    @Column(name = "discription",nullable = false)
    @NotEmpty
    private String discription;


    @Column(name = "author",nullable = false)
    @NotEmpty
    private String author;


    @Column(name = "producer",nullable = false)
    @NotEmpty
    private String producer;


    @Column(name = "Rented",nullable = false)
    @NotEmpty
    private LocalDateTime dayOfRent;


    @Column(name = "estimated_return_day",nullable = false)
    @NotEmpty
    private LocalDateTime estimatedReturnDay;


    @Column(name = "added_to_collection",nullable = false)
    @NotEmpty
    private LocalDateTime addedToLibrary;

    @Column(name = "rented_by",nullable = false)
    private User lastPersonWhoRent;

    @Column(name = "all_person_that_rent")
    private List<User> listOfPeopleThatRentBook;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Library library;

}
