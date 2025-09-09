package gradproj.demo.notice.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestNoticeUpdateDto {
    public long postId;
    public String title;
    public String content;

    public CRequestNoticeUpdateDto(long postId, String title, String content) {
        this.postId = postId;
        this.title = title;
        this.content = content;
    }
}
