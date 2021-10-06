package nl.novi.studentcourse.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StudentCourseResultKey implements Serializable {

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "course_id")
    private Long courseId;

    // constructor(s)
    public StudentCourseResultKey() {}
    public StudentCourseResultKey(long studentId, long courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    // getters and setters
    public Long getStudentId() {
        return studentId;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    public Long getCourseId() {
        return courseId;
    }
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentCourseResultKey that = (StudentCourseResultKey) o;
        return studentId.equals(that.studentId) &&
                courseId.equals(that.courseId);
    }

    // hashcode
    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId);
    }
}