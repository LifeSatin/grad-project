package gradproj.demo.member.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestMemberNicknameUpdateDto {
    public long memberId;
    public String nickname;

    public CRequestMemberNicknameUpdateDto(long memberId, String nickname) {
        this.memberId = memberId;
        this.nickname = nickname;
    }
}
