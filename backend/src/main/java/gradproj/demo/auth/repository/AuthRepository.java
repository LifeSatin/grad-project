package gradproj.demo.auth.repository;

import gradproj.demo.auth.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthRepository extends JpaRepository<AuthToken, UUID> {
    public AuthToken deleteByLoginId(String loginId);

    public boolean existsByToken(UUID token);
}
