package gradproj.demo.comment.dto.controller.request;

import lombok.Getter;

@Getter
public class RequestCommentDeleteDto {
    public long commentId;

    public RequestCommentDeleteDto(long commentId) {
        this.commentId = commentId;
    }
}
