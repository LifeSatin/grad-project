package gradproj.demo.qboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QBoardRepository extends JpaRepository<Question, Long> {
}
