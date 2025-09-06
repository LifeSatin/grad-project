package gradproj.demo.member.dto.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestMemberNicknameUpdateDto {
    public long memberId;
    public String newNickname;

    public RequestMemberNicknameUpdateDto(long memberId, String newNickname) {
        this.memberId = memberId;
        this.newNickname = newNickname;
    }
}
