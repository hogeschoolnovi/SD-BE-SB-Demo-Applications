package nl.novi.studentcourse.repository;

import nl.novi.studentcourse.model.Course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Collection<Course> findAllByName(String name);
}
