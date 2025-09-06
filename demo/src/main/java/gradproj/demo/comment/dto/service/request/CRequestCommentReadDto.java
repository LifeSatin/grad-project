package gradproj.demo.comment.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestCommentReadDto {
    public long postId;

    public CRequestCommentReadDto(long postId) {
        this.postId = postId;
    }
}
