package nl.novi.repository;

import nl.novi.model.CourseRating;
import nl.novi.model.CourseRatingKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRatingRepository extends JpaRepository<CourseRating, CourseRatingKey> {

}
