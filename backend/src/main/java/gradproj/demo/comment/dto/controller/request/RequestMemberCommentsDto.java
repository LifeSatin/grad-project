package gradproj.demo.comment.dto.controller.request;

import lombok.Getter;

@Getter
public class RequestMemberCommentsDto {
    public long memberId;

    public RequestMemberCommentsDto(long memberId) {
        this.memberId = memberId;
    }
}
