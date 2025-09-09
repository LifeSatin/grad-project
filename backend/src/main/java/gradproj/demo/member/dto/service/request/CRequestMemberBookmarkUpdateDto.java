package gradproj.demo.member.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestMemberBookmarkUpdateDto {
    public long memberId;

    public CRequestMemberBookmarkUpdateDto(long memberId) {
        this.memberId = memberId;
    }
}
