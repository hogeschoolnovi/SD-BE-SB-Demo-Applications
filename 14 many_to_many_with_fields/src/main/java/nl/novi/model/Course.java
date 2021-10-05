package nl.novi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
class Course {

    @Id
    Long id;

    String name;

    @OneToMany(mappedBy = "course")
    List<CourseRating> ratings;

    // additional properties
    // standard constructors, getters, and setters
}