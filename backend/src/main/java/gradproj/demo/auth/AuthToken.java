package gradproj.demo.auth;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class AuthToken {
    @Id @Column(name = "token")
    public String token;
    public String loginId;
    public String level;

    public AuthToken(String token, String loginId, String level) {
        this.token = token;
        this.loginId = loginId;
        this.level = level;
    }

    public AuthToken() {
    }
}
