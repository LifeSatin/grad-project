package gradproj.demo.member.dto;

import lombok.Getter;

@Getter
public class RequestMemberNicknameUpdateDto {
    public int memberId;
    public String newNickname;
}
