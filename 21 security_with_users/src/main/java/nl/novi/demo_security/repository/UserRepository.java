package nl.novi.demo_security.repository;

import nl.novi.demo_security.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
