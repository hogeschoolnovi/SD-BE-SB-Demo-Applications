package nl.novi.studentcourse.service;

import nl.novi.studentcourse.exceptions.RecordNotFoundException;
import nl.novi.studentcourse.model.Course;
import nl.novi.studentcourse.model.Student;
import nl.novi.studentcourse.model.StudentCourseResult;
import nl.novi.studentcourse.model.StudentCourseResultKey;
import nl.novi.studentcourse.repository.CourseRepository;
import nl.novi.studentcourse.repository.StudentCourseResultRepository;
import nl.novi.studentcourse.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentCourseResultService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentCourseResultRepository studentCourseResultRepository;

    public Collection<StudentCourseResult> getAllResults() {
        Collection<StudentCourseResult> results = studentCourseResultRepository.findAll();
        return results;
    }

    public Collection<StudentCourseResult> getResultsByStudentId(long studentId) {
        return studentCourseResultRepository.findAllByStudentId(studentId);
    }

    public Collection<StudentCourseResult> getResultsByCourseId(long courseId) {
        return studentCourseResultRepository.findAllByCourseId(courseId);
    }

    public StudentCourseResult getResultById(long studentId, long courseId) {
        return studentCourseResultRepository.findById(new StudentCourseResultKey(studentId, courseId)).orElse(null);
    }

    public StudentCourseResultKey addResult(long studentId, long courseId, StudentCourseResult result) {
        if (!studentRepository.existsById(studentId)) { throw new RecordNotFoundException(); }
        Student student = studentRepository.findById(studentId).orElse(null);
        if (!courseRepository.existsById(courseId)) { throw new RecordNotFoundException(); }
        Course course = courseRepository.findById(courseId).orElse(null);
        result.setStudent(student);
        result.setCourse(course);
        StudentCourseResultKey id = new StudentCourseResultKey(studentId, courseId);
        result.setId(id);
        studentCourseResultRepository.save(result);
        return id;
    }

    public void updateResult(long studentId, long courseId, StudentCourseResult result) {
        StudentCourseResultKey id = new StudentCourseResultKey(studentId, courseId);
        if (!studentCourseResultRepository.existsById(id)) { throw new RecordNotFoundException(); }
        StudentCourseResult existingResult = studentCourseResultRepository.findById(id).orElse(null);
        existingResult.setDate(result.getDate());
        existingResult.setScore(result.getScore());
        studentCourseResultRepository.save(existingResult);
    }

    public void partialUpdateResult(long studentId, long courseId, StudentCourseResult result) {
        StudentCourseResultKey id = new StudentCourseResultKey(studentId, courseId);
        if (!studentCourseResultRepository.existsById(id)) { throw new RecordNotFoundException(); }
        StudentCourseResult existingResult = studentCourseResultRepository.findById(id).orElse(null);
        if (result.getDate() != null) {
            existingResult.setDate(result.getDate());
        }
        if (result.getScore() != null) {
            existingResult.setScore(result.getScore());
        }
        studentCourseResultRepository.save(existingResult);
    }

    public void deleteResult(long studentId, long courseId) {
        StudentCourseResultKey id = new StudentCourseResultKey(studentId, courseId);
        if (!studentCourseResultRepository.existsById(id)) { throw new RecordNotFoundException(); }
        studentCourseResultRepository.deleteById(id);
    }

}
