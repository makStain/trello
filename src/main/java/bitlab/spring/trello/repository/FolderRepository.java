package bitlab.spring.trello.repository;

import bitlab.spring.trello.model.Folders;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface FolderRepository extends JpaRepository<Folders, Long> {
}
