package nl.novi.studentcourse.controller;

import nl.novi.studentcourse.model.Course;
import nl.novi.studentcourse.model.StudentCourseResult;
import nl.novi.studentcourse.model.StudentCourseResultKey;
import nl.novi.studentcourse.service.CourseService;
import nl.novi.studentcourse.service.StudentCourseResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

/**
 * CourseController
 * Implements endpoints for course resource
 *
 * GET /courses
 * POST /courses
 * GET /courses/{id}
 * PUT /courses/{id}
 * PATCH /courses/{id}
 * DELETE /courses/{id}
 *
 * GET /courses/{id}/courses => return courses with id
 *
 */


@RestController
@CrossOrigin
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @Autowired
    private StudentCourseResultService studentCourseResultService;

    @GetMapping(value = "")
    public ResponseEntity<Object> searchCourses(@RequestParam(name="name", defaultValue="") String name) {
        return ResponseEntity.ok().body(courseService.getCourses(name));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getCourse(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(courseService.getCourseById(id));
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> createCourse(@RequestBody Course course) {
        long newId = courseService.createCourse(course);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newId).toUri();

        return ResponseEntity.created(location).body(location);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateCourse(@PathVariable("id") long id, @RequestBody Course course) {
        courseService.updateCourse(id, course);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Object> updateCoursePartial(@PathVariable("id") long id, @RequestBody Map<String, String> fields) {
        courseService.partialUpdateCourse(id, fields);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable("id") long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}/students")
    public ResponseEntity<Object> getStudentCourseResults(@PathVariable("id") long id) {
        return ResponseEntity.ok().body(studentCourseResultService.getResultsByCourseId(id));
    }

    @GetMapping(value = "/{course_id}/students/{student_id}")
    public ResponseEntity<Object> getStudentCourseResult(@PathVariable("course_id") long courseId,
                                                         @PathVariable("student_id") long studentId) {
        return ResponseEntity.ok().body(studentCourseResultService.getResultById(studentId, courseId));
    }

    @PostMapping(value = "/{course_id}/students/{student_id}")
    public ResponseEntity<Object> addStudentCourseResult(@PathVariable("course_id") long courseId,
                                                         @PathVariable("student_id") long studentId,
                                                         @RequestBody StudentCourseResult result) {
        StudentCourseResultKey newId = studentCourseResultService.addResult(courseId, studentId, result);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();

        return ResponseEntity.created(location).body(location);
    }

}
