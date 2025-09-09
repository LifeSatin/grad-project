package gradproj.demo.member.dto.controller.request;

import lombok.Getter;

@Getter
public class RequestMemberBookmarkUpdateDto {
    public long memberId;

    public RequestMemberBookmarkUpdateDto(long memberId) {
        this.memberId = memberId;
    }
}
