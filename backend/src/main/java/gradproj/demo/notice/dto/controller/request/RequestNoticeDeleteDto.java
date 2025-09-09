package gradproj.demo.notice.dto.controller.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestNoticeDeleteDto {
    public long postId;

    public RequestNoticeDeleteDto(long postId) {
        this.postId = postId;
    }
}
