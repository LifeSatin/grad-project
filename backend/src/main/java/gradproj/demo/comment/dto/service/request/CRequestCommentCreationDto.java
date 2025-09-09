package gradproj.demo.comment.dto.service.request;

import lombok.Getter;

@Getter
public class CRequestCommentCreationDto {
    public String content;
    public long boardId;
    public long postId;
    public long authorId;

    public CRequestCommentCreationDto(String content, long boardId, long postId, long authorId) {
        this.content = content;
        this.boardId = boardId;
        this.postId = postId;
        this.authorId = authorId;
    }
}
