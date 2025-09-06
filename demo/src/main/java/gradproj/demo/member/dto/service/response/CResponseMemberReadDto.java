package gradproj.demo.member.dto.service.response;

import lombok.Getter;

@Getter
public class CResponseMemberReadDto {
    public String id;
    public String nickname;
    public String power;

    public CResponseMemberReadDto(String id, String nickname, String power) {
        this.id = id;
        this.nickname = nickname;
        this.power = power;
    }
}
