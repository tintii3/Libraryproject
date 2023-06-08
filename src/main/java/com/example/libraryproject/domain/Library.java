package com.example.libraryproject.domain;

import com.example.libraryproject.exception.student.StudentUnassignedException;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;
import java.util.stream.Collectors;

@Data
@ToString(exclude = {"libraryStudents"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "library_id")
    private Integer libraryId;

    @NonNull
    @Column(name = "library_name")
    private String libraryName;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @NonNull
    @Column(name = "is_active")
    private Boolean isActive;

//    @OneToOne(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Address libraryAddress;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> libraryBooks = new ArrayList<>();

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<LibraryStudent> libraryStudents = new HashSet<>();

    @OneToOne(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    private Location location;

    public boolean isActive(){
        return this.isActive;
    }
    public void activate(){
        this.isActive = true;
    }
    public void deactivate(){
        this.isActive = false;
    }
    public boolean hasStudent(Integer studentId){
        return this.getAssignedStrdents().stream().anyMatch((student) -> {
            return student.getStudentId().equals(studentId);
        });
    }

    public void addStudent(Student student){
        LibraryStudent libraryStudent = new LibraryStudent(this, student);
        this.libraryStudents.add(libraryStudent);

    }
    public void removeStudent(Student student){
        LibraryStudent libraryStudent = this.getStudentRelationship(student);
        libraryStudent.unsetRelationship();
    }
    public Collection<Student> getAssignedStrdents(){
        return this.libraryStudents.stream()
                .map(LibraryStudent::getStudent)
                .collect(Collectors.toList());
    }

    public LibraryStudent getStudentRelationship(Student student){
        return this.libraryStudents.stream()
                .filter(libraryStudent -> libraryStudent.getStudent().getStudentId().equals(student.getStudentId()))
                .findAny()
                .orElseThrow(() -> new StudentUnassignedException("Library does not have this student assigned."));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return libraryId.equals(library.libraryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryId);
    }

    public Integer getLibraryId() {
        return libraryId;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public Boolean getActive() {
        return isActive;
    }

    public List<Book> getLibraryBooks() {
        return libraryBooks;
    }

    public Set<LibraryStudent> getLibraryStudents() {
        return libraryStudents;
    }

    public boolean hasLocation() {
        return Objects.nonNull(this.location);
    }

    public void unsetRelationship(Location location) {
        this.location = null;
        location.setLibrary(null);
    }
}
