package bitlab.spring.trello.repository;

import bitlab.spring.trello.model.Tasks;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TaskRepository extends JpaRepository<Tasks, Long> {
}
