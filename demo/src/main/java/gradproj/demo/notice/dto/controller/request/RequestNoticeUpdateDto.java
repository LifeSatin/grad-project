package gradproj.demo.notice.dto.controller.request;

import lombok.Getter;

@Getter
public class RequestNoticeUpdateDto {
    public int postId;
    public String title;
    public String content;

    public RequestNoticeUpdateDto(int postId, String title, String content) {
        this.postId = postId;
        this.title = title;
        this.content = content;
    }
}
