package gradproj.demo.member.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestMemberBookmarkReadDto {
    public long memberId;

    public CRequestMemberBookmarkReadDto(long memberId) {
        this.memberId = memberId;
    }
}
