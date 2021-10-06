package nl.novi.studentcourse.repository;

import nl.novi.studentcourse.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findAllByLastName(String last_name);
}
