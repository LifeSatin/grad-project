package gradproj.demo.notice.dto;

import lombok.Getter;

@Getter
public class RequestNoticeUpdateDto {
    public int postId;
    public String title;
    public String content;
}
