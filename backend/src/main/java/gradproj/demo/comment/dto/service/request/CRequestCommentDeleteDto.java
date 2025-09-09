package gradproj.demo.comment.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestCommentDeleteDto {
    public long commentId;

    public CRequestCommentDeleteDto(long commentId) {
        this.commentId = commentId;
    }
}
