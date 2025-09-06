package gradproj.demo.discussion.dto.controller.request;

import lombok.Getter;

import java.time.LocalDateTime;

// 토론 게시판 게시글 생성용 DTO
@Getter
public class RequestDiscussCreationDto {
    public int boardId;
    public int authorId;
    public String title;
    public String content;
    public LocalDateTime date;
}
