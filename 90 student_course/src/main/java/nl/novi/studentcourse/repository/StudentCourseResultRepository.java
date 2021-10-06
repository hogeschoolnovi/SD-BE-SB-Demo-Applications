package nl.novi.studentcourse.repository;

import nl.novi.studentcourse.model.StudentCourseResult;
import nl.novi.studentcourse.model.StudentCourseResultKey;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StudentCourseResultRepository extends JpaRepository<StudentCourseResult, StudentCourseResultKey> {
    Collection<StudentCourseResult> findAllByStudentId(long studentId);
    Collection<StudentCourseResult> findAllByCourseId(long courseId);
}
