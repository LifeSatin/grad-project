package gradproj.demo.wiki;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WikiRepository extends JpaRepository<Page, String> {
    @Query(value = "SELECT p FROM Page p WHERE p.page_name LIKE %:query%", nativeQuery = true)
    List<Page> findByPageNameLike(@Param("query") String query);
}
