package gradproj.demo.member.dto.controller.request;

import lombok.Getter;

@Getter
public class RequestMemberBookmarkReadDto {
    public long memberId;

    public RequestMemberBookmarkReadDto(long memberId) {
        this.memberId = memberId;
    }
}
