package gradproj.demo.member.dto.controller.request;

import lombok.Getter;

@Getter
public class RequestMemberNicknameUpdateDto {
    public int memberId;
    public String newNickname;
}
