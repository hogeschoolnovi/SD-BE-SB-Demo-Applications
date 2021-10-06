package nl.novi.books_api.repository;

import nl.novi.books_api.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
