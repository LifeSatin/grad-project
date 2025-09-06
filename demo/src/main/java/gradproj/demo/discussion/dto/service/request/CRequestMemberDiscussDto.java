package gradproj.demo.discussion.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestMemberDiscussDto {
    public long memberId;

    public CRequestMemberDiscussDto(long memberId) {
        this.memberId = memberId;
    }
}
