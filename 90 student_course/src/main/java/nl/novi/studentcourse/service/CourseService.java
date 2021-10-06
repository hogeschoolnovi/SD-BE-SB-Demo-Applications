package nl.novi.studentcourse.service;

import nl.novi.studentcourse.exceptions.RecordNotFoundException;
import nl.novi.studentcourse.model.Course;
import nl.novi.studentcourse.repository.CourseRepository;
import nl.novi.studentcourse.repository.StudentCourseResultRepository;
import nl.novi.studentcourse.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;


@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRespository;

    @Autowired
    StudentCourseResultRepository studentCourseResultRepository;

    public Collection<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Collection<Course> getCourses(String name) {
        if (name.isEmpty()) {
            return courseRepository.findAll();
        }
        else {
            return courseRepository.findAllByName(name);
        }
    }

    public Course getCourseById(long id) {
        if (!courseRepository.existsById(id)) { throw new RecordNotFoundException(); }
        return courseRepository.findById(id).orElse(null);
    }

    public long createCourse(Course course) {
        Course storedCourse = courseRepository.save(course);
        return storedCourse.getId();
    }

    public void updateCourse(long id, Course course) {
        // ToDo
    }

    public void partialUpdateCourse(long id, Map<String, String> fields) {
        // ToDo
    }

    public void deleteCourse(long id) {
        if (!courseRepository.existsById(id)) { throw new RecordNotFoundException(); }
        courseRepository.deleteById(id);
    }

}
