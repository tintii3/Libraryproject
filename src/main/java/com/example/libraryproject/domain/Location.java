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
@Table(name = "location")
public class Location {
    @Id
    @Column(name = "location_id")
    private Integer locationId;

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
    @JoinColumn(name = "library_id")
    private Library library;

}
