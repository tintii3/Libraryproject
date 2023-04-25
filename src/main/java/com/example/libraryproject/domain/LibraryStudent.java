package com.example.libraryproject.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@ToString(exclude = {"library", "student"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "library_student")
public class LibraryStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "library)student_id")
    private Integer libraryStudentIn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "library_id")
    private Library library;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @NonNull
    @Column(name = "is_active")
    private Boolean isActive;

    public LibraryStudent(Library library, Student student){
        this.library = library;
        this.student = student;
        this.isActive = true;
    }

    public void unsetRelationship(){
        this.library.getLibraryStudents().remove(this);
        this.student.getLibraries().remove(this);
        this.library = null;
        this.student = null;
    }
}
