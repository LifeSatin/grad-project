package gradproj.demo.comment.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestCommentCreationDto {
    public String content;
    public long postId;
    public long authorId;

    public CRequestCommentCreationDto(String content, long postId, long authorId) {
        this.content = content;
        this.postId = postId;
        this.authorId = authorId;
    }
}
