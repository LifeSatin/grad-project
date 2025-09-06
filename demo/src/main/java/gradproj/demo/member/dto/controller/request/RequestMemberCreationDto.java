package gradproj.demo.member.dto.controller.request;

import lombok.Getter;


@Getter
public class RequestMemberCreationDto {
    public String id;
    public String password;
    public String nickname;

    public RequestMemberCreationDto(String id, String password, String nickname) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
    }
}
