package gradproj.demo.comment.dto.controller.request;

import lombok.Getter;

@Getter
public class RequestCommentUpdateDto {
    public long commentId;
    public String content;

    public RequestCommentUpdateDto(long commentId, String content) {
        this.commentId = commentId;
        this.content = content;
    }
}
