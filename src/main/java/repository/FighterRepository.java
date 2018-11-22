package repository;

import model.Fighter;
import org.springframework.data.repository.CrudRepository;

public interface FighterRepository extends CrudRepository<Fighter, Long> {
}
