package gradproj.demo.comment.dto.controller.request;

import lombok.Getter;

@Getter
public class RequestCommentCreationDto {

    public String content;
    public long boardId;
    public long postId;
    public String authorToken;

    public RequestCommentCreationDto(String content, long boardId, long postId, String authorToken) {
        this.content = content;
        this.boardId = boardId;
        this.postId = postId;
        this.authorToken = authorToken;
    }
}