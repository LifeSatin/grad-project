package gradproj.demo.discussion.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestDiscussUpdateDto {
    public long postId;
    public String title;
    public String content;

    public CRequestDiscussUpdateDto(long postId, String title, String content) {
        this.postId = postId;
        this.title = title;
        this.content = content;
    }
}
