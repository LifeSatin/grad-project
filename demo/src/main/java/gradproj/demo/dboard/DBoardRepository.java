package gradproj.demo.dboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBoardRepository extends JpaRepository<DBoard, Long> {
}
