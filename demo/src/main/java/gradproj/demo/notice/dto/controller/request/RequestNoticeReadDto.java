package gradproj.demo.notice.dto.controller.request;

import lombok.Getter;

@Getter
public class RequestNoticeReadDto {
    public long postId;

    public RequestNoticeReadDto(long postId) {
        this.postId = postId;
    }
}
