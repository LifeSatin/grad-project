package gradproj.demo.discussion.dto.controller.request;

import lombok.Getter;

@Getter
public class RequestMemberDiscussListDto {
    public long memberId;

    public RequestMemberDiscussListDto(long memberId) {
        this.memberId = memberId;
    }
}
