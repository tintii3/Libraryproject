package com.example.libraryproject.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "address_id")
    private Integer addressId;

    @NonNull
    @Column(name = "street")
    private String street;

    @NonNull
    @Column(name = "city")
    private String city;

    @NonNull
    @Column(name = "country")
    private String country;

    @OneToOne
    @MapsId
    @JoinColumn(name = "student_id")
    private Student student;
}
