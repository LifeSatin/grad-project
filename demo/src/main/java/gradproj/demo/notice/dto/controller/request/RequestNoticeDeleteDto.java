package gradproj.demo.notice.dto.controller.request;

import lombok.Getter;

@Getter
public class RequestNoticeDeleteDto {
    public long postId;

    public RequestNoticeDeleteDto(long postId) {
        this.postId = postId;
    }
}
