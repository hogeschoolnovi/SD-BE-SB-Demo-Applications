package nl.novi.repository;

import nl.novi.model.Speler;
import nl.novi.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface SpelerRepository extends CrudRepository<Speler, Long> {
}
