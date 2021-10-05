package nl.novi.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CourseRatingKey implements Serializable {

    @Column(name = "student_id")
    Long studentId;

    @Column(name = "course_id")
    Long courseId;

    public Long getStudentId() {
        return this.studentId;
    }

    public Long getCourseId() {
        return this.courseId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CourseRatingKey)) return false;
        final CourseRatingKey other = (CourseRatingKey) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$studentId = this.getStudentId();
        final Object other$studentId = other.getStudentId();
        if (this$studentId == null ? other$studentId != null : !this$studentId.equals(other$studentId)) return false;
        final Object this$courseId = this.getCourseId();
        final Object other$courseId = other.getCourseId();
        if (this$courseId == null ? other$courseId != null : !this$courseId.equals(other$courseId)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CourseRatingKey;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $studentId = this.getStudentId();
        result = result * PRIME + ($studentId == null ? 43 : $studentId.hashCode());
        final Object $courseId = this.getCourseId();
        result = result * PRIME + ($courseId == null ? 43 : $courseId.hashCode());
        return result;
    }

    // standard constructors, getters, and setters
    // hashcode and equals implementation
}