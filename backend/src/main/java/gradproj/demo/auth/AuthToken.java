package gradproj.demo.auth;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
public class AuthToken {
    @Id @Column(name = "token")
    public String token;
    public long id;
    public String level;

    public AuthToken(String token, long id, String level) {
        this.token = token;
        this.id = id;
        this.level = level;
    }

    public AuthToken() {
    }
}
