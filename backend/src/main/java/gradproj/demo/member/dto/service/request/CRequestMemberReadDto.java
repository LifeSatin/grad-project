package gradproj.demo.member.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestMemberReadDto {
    public long memberId;

    public CRequestMemberReadDto(long memberId) {
        this.memberId = memberId;
    }
}
