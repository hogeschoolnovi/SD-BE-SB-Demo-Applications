package nl.novi.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

    @Id
    Long id;

    @ManyToMany
    @JoinTable(
            name = "students_attending_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    Set<Course> courses = new HashSet<>();

    // standard constructors
    // getters, and setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Set<Course> getCourses() { return courses; }
    public void setCourses(Set<Course> courses) { this.courses = courses; }

}