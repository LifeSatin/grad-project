package gradproj.demo.comment.dto.controller.request;

import lombok.Getter;

@Getter
public class RequestCommentCreationDto {

    public String content;
    public long boardId;
    public long postId;
    public long authorId;

    public RequestCommentCreationDto(String content, long boardId, long postId, long authorId) {
        this.content = content;
        this.boardId = boardId;
        this.postId = postId;
        this.authorId = authorId;
    }
}