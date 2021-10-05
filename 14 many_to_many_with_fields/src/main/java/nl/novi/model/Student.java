package nl.novi.model;

import javax.persistence.*;
import java.util.List;

@Entity
class Student {

    @Id
    Long id;

    String name;

    @OneToMany(mappedBy = "student")
    List<CourseRating> ratings;

    // additional properties
    // standard constructors, getters, and setters
}