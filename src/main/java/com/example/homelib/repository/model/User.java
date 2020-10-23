package com.example.homelib.repository.model;
/* ---------------------------------------------------------------------------------------------------------
============================================================================================================
========created_by_Daniel_Słota_a.k.a._Kamien_date:14-10-2020r.=============================================
============================================================================================================
 -----------------------------------------------------------------------------------------------------------*/


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Getter
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_index", nullable = false, length = 10)
    @NotEmpty
    private Long studenIndex;

    @Column(name = "first_name", nullable = false)
    @NotEmpty
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotEmpty
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    @NotEmpty
    @Email
    private String email;

    @Column(name = "Can_rent_a_book", nullable = false)
    @NotEmpty
    private boolean canRentABook;

    @Column(name = "signed_up",nullable = false)
    @NotEmpty
    private LocalDateTime creaetdOn;

    @Column (name = "Role")
    @NotEmpty
    private String role;

    @Column(name = "summary_of_books_rented",nullable = false)
    @NotEmpty
    private int sumOfBooksRented;
    
    @Column(name = "penelty",nullable = false)
    @NotEmpty
    private int sumOfPeneltyToPay;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_library",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "library_id"))
    private Set<Library> librarys;


    public void addLibrary(Library library){
        librarys.add(library);
    }

    public void removeLibrary(Library library){
        librarys.remove(library);
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", studenIndex=" + studenIndex +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", canRentABook=" + canRentABook +
                ", creaetdOn=" + creaetdOn +
                ", role='" + role + '\'' +
                ", sumOfBooksRented=" + sumOfBooksRented +
                ", sumOfPeneltyToPay=" + sumOfPeneltyToPay +
                ", librarys=" + librarys +
                '}';
    }
}
