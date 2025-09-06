package gradproj.demo.member.dto.controller.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseMemberReadDto {
    public String id;
    public String nickname;
    public String power;

    public ResponseMemberReadDto(String id, String nickname, String power) {
        this.id = id;
        this.nickname = nickname;
        this.power = power;
    }
}
