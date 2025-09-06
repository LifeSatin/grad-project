package gradproj.demo.member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
public class Member {
    @Id @GeneratedValue
    private long id;
    @Getter
    private String loginId;
    private String password;
    @Getter
    private String nickname;
    @Getter
    private String power;

    public Member() {

    }

    public Member(String loginId, String password, String nickname) {
        this.loginId = loginId;
        this.password = password;
        this.nickname = nickname;
        this.power = "regular";
    }
}
