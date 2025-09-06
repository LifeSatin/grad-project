package gradproj.demo.comment.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestCommentUpdateDto {
    public long commentId;
    public String content;

    public CRequestCommentUpdateDto(long commentId, String content) {
        this.commentId = commentId;
        this.content = content;
    }
}
