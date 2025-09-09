package gradproj.demo.discussion.dto.controller.request;

import lombok.Getter;

import java.time.LocalDateTime;

// 토론 게시판 게시글 생성용 DTO
@Getter
public class RequestDiscussCreationDto {
    public String title;
    public String content;
    public long boardId;
    public long authorId;

    public RequestDiscussCreationDto(String title, String content, long boardId, long authorId) {
        this.title = title;
        this.content = content;
        this.boardId = boardId;
        this.authorId = authorId;
    }
}
