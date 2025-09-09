package gradproj.demo.notice.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestNoticeDeleteDto {
    public long postId;

    public CRequestNoticeDeleteDto(long postId) {
        this.postId = postId;
    }
}
