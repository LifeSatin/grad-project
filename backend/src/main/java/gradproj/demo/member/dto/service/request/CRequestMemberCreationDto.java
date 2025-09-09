package gradproj.demo.member.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestMemberCreationDto {
    public String id;
    public String password;
    public String nickname;

    public CRequestMemberCreationDto(String id, String password, String nickname) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
    }
}
