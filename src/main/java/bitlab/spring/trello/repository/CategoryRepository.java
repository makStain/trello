package bitlab.spring.trello.repository;

import bitlab.spring.trello.model.TaskCategories;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<TaskCategories, Long> {
}
