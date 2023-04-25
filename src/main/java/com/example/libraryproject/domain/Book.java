package com.example.libraryproject.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;

    @NonNull
    @Column(name = "title")
    private String title;

    @Column(name = "authpr")
    private String author;

    @Getter
    @Setter
    @NonNull
    @Column(name = "is_active")
    private Boolean isActrive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "library_id")
    private Library library;

    public void activate(){
        this.isActrive = true;
    }
    public void deactivate(){
        this.isActrive = false;
    }

}
