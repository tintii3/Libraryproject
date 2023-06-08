package com.example.libraryproject.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@ToString(exclude = {})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    @NonNull
    @Column(name = "first_name")
    private String firstName;


    @NonNull
    @Column(name = "last_name")
    private String lastName;

    @NonNull
    @Column(name = "age")
    private Integer age;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @NonNull
    @Column(name = "is_active")
    private Boolean isActive;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<LibraryStudent> libraries = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId.equals(student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    public Boolean isActive() {
        return this.isActive;
    }

    public void activate() {
        this.isActive = true;
    }
    public void deactivate() {
        this.isActive = false;
    }

    public boolean hasAddress() {
        return Objects.nonNull(this.address);
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void unsetRelationship(Address address){
        this.address = address;
        address.setStudent(null);
    }
}
