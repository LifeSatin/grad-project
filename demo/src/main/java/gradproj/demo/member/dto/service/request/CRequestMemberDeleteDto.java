package gradproj.demo.member.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestMemberDeleteDto {
    public long memberId;

    public CRequestMemberDeleteDto(long memberId) {
        this.memberId = memberId;
    }
}
